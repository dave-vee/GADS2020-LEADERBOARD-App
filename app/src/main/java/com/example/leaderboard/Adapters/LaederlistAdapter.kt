package com.example.leaderboard.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leaderboard.R
import com.example.leaderboard.data.learning_leaders
import kotlinx.android.synthetic.main.recyclerview_learningleader.view.*


class LeaderListAdapter(private val leadersList: List<learning_leaders>) :
    RecyclerView.Adapter<LeaderListAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindLeaderData(data: learning_leaders) {
            with(data) {
                itemView.name.text = name.toString()
                itemView.hours.text = hours.toString()
                itemView.country.text = country.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_learningleader, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("TAG", "onBindViewHolder:$position ")
        holder.bindLeaderData(leadersList[position])
    }

    override fun getItemCount(): Int {
        return leadersList.size
    }


}