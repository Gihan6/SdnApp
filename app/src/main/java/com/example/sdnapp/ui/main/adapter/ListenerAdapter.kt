package com.example.sdnapp.ui.main.adapter

import com.example.sdnapp.db.Repo


interface ListenerAdapter {
    fun onLongClick(position: Repo)
}