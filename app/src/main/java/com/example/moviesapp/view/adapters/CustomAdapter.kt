package com.example.moviesapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Result
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList : List<Result>, val mItemClickListener : ItemClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClickListener{
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem) {
        val textView : TextView = itemView.findViewById(R.id.textView)
        val imageView : ImageView = itemView.findViewById(R.id.imageview)
        init {
            viewItem.setOnClickListener{
//                mItemClickListener.onItemClick(adapterPosition)
                mList?.get(position)?.id?.let {it -> mItemClickListener.onItemClick(it) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = mList[position]
        holder.textView.text = itemViewModel.title
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + mList[position].poster_path).into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return mList.size
    }


}