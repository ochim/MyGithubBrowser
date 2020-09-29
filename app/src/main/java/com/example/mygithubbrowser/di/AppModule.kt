package com.example.mygithubbrowser.di

import android.app.Application
import androidx.room.Room
import com.example.mygithubbrowser.api.AuthenticationInterceptor
import com.example.mygithubbrowser.api.GithubAuthService
import com.example.mygithubbrowser.api.GithubService
import com.example.mygithubbrowser.db.GithubDb
import com.example.mygithubbrowser.db.RepoDao
import com.example.mygithubbrowser.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideGithubService(
        authenticationInterceptor: AuthenticationInterceptor
    ): GithubService {
        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .addInterceptor(authenticationInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(client)
            .build()
            .create(GithubService::class.java)
    }

    @Singleton
    @Provides
    fun provideGithubAuthService(): GithubAuthService {
        return Retrofit.Builder()
            .baseUrl("https://github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubAuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): GithubDb {
        return Room
            .databaseBuilder(app, GithubDb::class.java, "github.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRepoDao(db: GithubDb): RepoDao {
        return db.repoDao()
    }
}
