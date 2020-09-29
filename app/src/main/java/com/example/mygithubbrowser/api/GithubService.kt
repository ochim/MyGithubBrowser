package com.example.mygithubbrowser.api

import androidx.lifecycle.LiveData
import com.example.mygithubbrowser.vo.Contributor
import com.example.mygithubbrowser.vo.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * REST API access points
 *
 * Pagination: 30 items by default
 * https://developer.github.com/v3/#pagination
 *
 * Search repositories
 * https://developer.github.com/v3/search/#search-repositories
 *
 * Repositories
 * https://developer.github.com/v3/repos/
 */
interface GithubService {

    @GET("repos/{owner}/{name}")
    fun getRepo(
        @Path("owner") owner: String,
        @Path("name") name: String
    ): LiveData<ApiResponse<Repo>>

    @GET("repos/{owner}/{name}/contributors")
    fun getContributors(
        @Path("owner") owner: String,
        @Path("name") name: String
    ): LiveData<ApiResponse<List<Contributor>>>

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): LiveData<ApiResponse<RepoSearchResponse>>

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String, @Query("page") page: Int): Call<RepoSearchResponse>
}
