package com.bankmandiri.poc.coroutineparallel.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bankmandiri.poc.coroutineparallel.R
import com.bankmandiri.poc.coroutineparallel.model.ActivityResponse
import kotlinx.android.synthetic.main.rv_layout.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val data: ArrayList<ActivityResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    fun updateData(data: List<ActivityResponse>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bindView(activityResponse: ActivityResponse){
            view.title.text = activityResponse.title
        }
    }
}
