package com.example.mygithubbrowser.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mygithubbrowser.vo.Contributor
import com.example.mygithubbrowser.vo.Repo
import com.example.mygithubbrowser.vo.RepoSearchResult

/**
 * Main database description.
 */
@Database(
    entities = [
        Repo::class,
        Contributor::class,
        RepoSearchResult::class],
    version = 3,
    exportSchema = false
)
abstract class GithubDb : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}
