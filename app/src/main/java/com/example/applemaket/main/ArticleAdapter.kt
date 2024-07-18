package com.example.applemaket.main

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter : ListAdapter<ArticleModel, ArticleAdapter.ViewHolder>(diffUtil){

    inner class ArticlItemViewHolder(private val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root)

}