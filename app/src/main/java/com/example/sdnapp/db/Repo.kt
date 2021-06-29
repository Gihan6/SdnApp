package com.example.sdnapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Repo")

data class Repo(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int,
    @ColumnInfo(name = "userid")
    @SerializedName("userid")
    var userid: String,
    @SerializedName("token")
    @ColumnInfo(name = "token")
    var token: String
)

