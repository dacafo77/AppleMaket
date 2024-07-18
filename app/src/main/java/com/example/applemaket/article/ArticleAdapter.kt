package com.example.applemaket.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.applemaket.databinding.ItemArticleBinding
import java.text.NumberFormat
import java.util.Locale

class ArticleAdapter(private val clickListener: (ArticleModel) -> Unit) : ListAdapter<ArticleModel, ArticleAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(articleModel: ArticleModel) {
            val formatprice = "${NumberFormat.getNumberInstance(Locale.KOREA).format(articleModel.pric)}원"

            binding.nameTextView.text = articleModel.name
            binding.addressTextView.text = articleModel.address
            binding.pricTextView.text = formatprice
            binding.thumbnailImageView.setImageResource(articleModel.imageUrl)

            binding.root.setOnClickListener {
                clickListener(articleModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ArticleModel>() {
            override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
