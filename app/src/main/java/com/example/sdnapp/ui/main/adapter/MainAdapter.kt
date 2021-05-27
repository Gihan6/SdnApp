package com.example.sdnapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sdnapp.R
import com.example.sdnapp.db.Repo
import java.util.*


class MainAdapter(private val repos: ArrayList<Repo>, private val listener: ListenerAdapter) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(repo: Repo) {
//            itemView.apply {
//                repoName.text = repo.name
//                repoOwner.text = repo.login
//                repoDesc.text = repo.description
//                if (repo.fork) {
//                    container.setBackgroundColor(
//                        ContextCompat.getColor(
//                            container.context,
//                            R.color.white
//                        )
//                    );
//                } else {
//                    container.setBackgroundColor(
//                        ContextCompat.getColor(
//                            container.context,
//                            R.color.colorAccent
//                        )
//                    );
//
//                }
//
//
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        )

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(repos[position])
//        holder.itemView.setOnLongClickListener(OnLongClickListener { v ->
//            listener.onLongClick(repos[position])
//            false
//        })
    }

    fun addRepos(repoList: List<Repo>) {
        this.repos.apply {
            addAll(repoList)
        }

    }

}