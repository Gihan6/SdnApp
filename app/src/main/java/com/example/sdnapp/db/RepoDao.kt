package com.example.sdnapp.db

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.sdnapp.model.Repo

@Dao

interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg repos: Repo?)

    @Query("select * from repo where name  LIKE :key ")
    fun filter(key: String): List<Repo>

    @Query("DELETE FROM Repo")
    fun clear()
}