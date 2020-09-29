package com.example.mygithubbrowser.di

import com.example.mygithubbrowser.ui.repo.RepoFragment
import com.example.mygithubbrowser.ui.search.SearchFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeRepoFragment(): RepoFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}
