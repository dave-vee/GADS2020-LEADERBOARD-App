package com.example.leaderboard.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leaderboard.R
import com.example.leaderboard.data.SkillIQ
import kotlinx.android.synthetic.main.recyclerview_skilliq.view.*


class SkillIQAdapter(private val IQList: List<SkillIQ>) :
    RecyclerView.Adapter<SkillIQAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(data: SkillIQ) {
            with(data) {
                itemView.name_IQ.text = name.toString()
                itemView.score_IQ.text = score.toString()
                itemView.country_name.text = country.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_skilliq, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(IQList[position])
    }

    override fun getItemCount(): Int = IQList.size
}
//
//class LeaderListAdapter(private val leadersList: learning_leaders) :
//    RecyclerView.Adapter<DataListAdapter.ViewHolder>() {
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bindData(data: learning_leaders) {
//            with(data) {
//                itemView.name_IQ.text = name.toString()
//                itemView.hours.text = hours.toString()
//                itemView.country.text = country.toString()
//            }
//        }
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from().inflate(R.layout.fragment_skilliq, parent, false)
//        return ViewHolder(view)
//    }
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindData(leadersList)
//    }
//    override fun getItemCount(): Int = leadersList.items.size
//
//
//}