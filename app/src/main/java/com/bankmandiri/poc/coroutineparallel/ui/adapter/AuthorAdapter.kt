package com.bankmandiri.poc.coroutineparallel.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bankmandiri.poc.coroutineparallel.R
import com.bankmandiri.poc.coroutineparallel.model.AuthorsResponse
import kotlinx.android.synthetic.main.rv_layout.view.*


class AuthorAdapter: RecyclerView.Adapter<AuthorAdapter.ViewHolder>() {

    val data: ArrayList<AuthorsResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    fun updateData(data: List<AuthorsResponse>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun bindView(activityResponse: AuthorsResponse){
            view.title.text = activityResponse.idBook.toString()
        }
    }
}