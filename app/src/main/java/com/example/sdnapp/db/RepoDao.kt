package com.example.sdnapp.db

import androidx.room.*

@Dao

interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg repos: Repo)

    @Query("select * from repo where id =1")
    fun getUser(): Repo

    @Query("DELETE FROM Repo")
    fun clear()
}