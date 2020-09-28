package com.example.mygithubbrowser.vo

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.mygithubbrowser.db.GithubTypeConverters

@Entity(primaryKeys = ["query"])
@TypeConverters(GithubTypeConverters::class)
data class RepoSearchResult(
    val query: String,
    val repoIds: List<Int>,
    val totalCount: Int,
    val next: Int?
)
