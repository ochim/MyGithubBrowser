package com.example.mygithubbrowser.api

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * REST API access points
 */
interface GithubAuthService {
    @POST("login/oauth/access_token")
    @Headers("Accept: application/json")
    suspend fun createAccessToken(@Body parameter: AccessTokenParameter): AccessTokenResponse
}
