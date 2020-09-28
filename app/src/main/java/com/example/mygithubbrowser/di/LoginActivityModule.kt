package com.example.mygithubbrowser.di

import com.example.mygithubbrowser.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class LoginActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity
}
