package com.example.sdnapp.ui.main.adapter

import com.example.sdnapp.model.Repo


interface ListenerAdapter {
    fun onLongClick(position: Repo)
}