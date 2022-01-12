package com.example.rv_inside_nestedscroll.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rv_inside_nestedscroll.R
import com.example.rv_inside_nestedscroll.model.User

class CustomAdapter(val context: Context, private val users: ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = users[position]

        if (holder is CustomViewHolder) {
            holder.textFirst.text = message.firstName
            holder.textSecond.text = message.lastName
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textFirst: TextView = itemView.findViewById(R.id.firstName)
        val textSecond: TextView = itemView.findViewById(R.id.lastName)
    }
}