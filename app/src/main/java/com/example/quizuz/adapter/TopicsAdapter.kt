package com.example.quizuz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizuz.R
import com.example.quizuz.model.TopicModel
import kotlinx.android.synthetic.main.topic_item_layout.view.*

interface TopicCallback{
    fun onClick(item: TopicModel)
}
class TopicsAdapter(val items: List<TopicModel>, val callback: TopicCallback): RecyclerView.Adapter<TopicsAdapter.TopicViewHolder>() {

    class TopicViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        return TopicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.topic_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.topic_textview.text = item.title
        holder.itemView.setOnClickListener{
            callback.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}