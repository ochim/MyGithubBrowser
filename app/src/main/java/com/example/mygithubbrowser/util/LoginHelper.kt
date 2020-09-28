package com.example.mygithubbrowser.util

import android.content.Intent
import android.net.Uri
import com.example.mygithubbrowser.BuildConfig
import com.example.mygithubbrowser.api.AccessTokenParameter
import com.example.mygithubbrowser.api.GithubAuthService
import com.example.mygithubbrowser.repository.AccessTokenRepository
import com.example.mygithubbrowser.vo.AccessToken
import timber.log.Timber
import javax.inject.Inject

class LoginHelper @Inject constructor(
    private val githubAuthService: GithubAuthService,
    private val accessTokenRepository: AccessTokenRepository
) {
    fun generateAuthorizationUrl(): Uri =
        Uri.Builder().apply {
            scheme("https")
            authority("github.com")
            appendPath("login")
            appendPath("oauth")
            appendPath("authorize")
            appendQueryParameter("client_id", BuildConfig.GITHUB_CLIENT_ID)
        }.build()

    suspend fun handleAuthRedirect(intent: Intent): Boolean {
        val uri = intent.data ?: return false
        if (!uri.toString().startsWith("dgbs://login")) return false
        val tempCode = uri.getQueryParameter("code") ?: return false

        Timber.i("code: $tempCode")

        val param = AccessTokenParameter(
            clientId = BuildConfig.GITHUB_CLIENT_ID,
            clientSecret = BuildConfig.GITHUB_CLIENT_SECRET,
            code = tempCode
        )

        return runCatching {
            val resp = githubAuthService.createAccessToken(param)
            accessTokenRepository.save(AccessToken(resp.accessToken))
        }.onFailure {
            Timber.e(it, "createAccessToken failed!")
        }.isSuccess
    }
}