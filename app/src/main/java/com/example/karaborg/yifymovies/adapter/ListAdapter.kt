package com.example.karaborg.yifymovies.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.karaborg.yifymovies.R
import com.example.karaborg.yifymovies.data.MovieResponse

class ListAdapter(private val list: MovieResponse, private var context: Context, var clickListener: ListAdapter.OnItemClickListener) : RecyclerView.Adapter<ListAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: MovieResponse = list
        holder.bind(movie, position, context)
    }

    override fun getItemCount(): Int = list.data!!.movies!!.size

    inner class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_listitem, parent, false)) {
        private var mTitleView: TextView? = null
        private var mImageView: ImageView? = null
        var mContainer: RelativeLayout

        init {
            mTitleView = itemView.findViewById(R.id.image_name)
            mImageView = itemView.findViewById(R.id.image)
            mContainer = itemView.findViewById(R.id.container)
        }

        fun bind(movie: MovieResponse, position:Int, context: Context) {
            mTitleView?.text = movie.data!!.movies!![position]!!.title
            Glide.with(context).load(movie.data.movies!![position]!!.smallCoverImage).into(mImageView)
            mContainer.setOnClickListener { clickListener.containerOnClick(position)}
            mImageView!!.setOnClickListener { clickListener.imageOnClick(position)}
        }
    }

    interface OnItemClickListener {
        fun containerOnClick(pos: Int)
        fun imageOnClick(pos: Int)
    }

}