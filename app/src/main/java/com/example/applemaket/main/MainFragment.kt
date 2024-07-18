package com.example.applemaket.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.applemaket.R
import com.example.applemaket.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {
    private var binding : FragmentMainBinding? = null
    private lateinit var articleAdapter: ArticleAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var fragmentMainBinding = FragmentMainBinding.bind(view)
        binding = fragmentMainBinding

        articleAdapter = ArticleAdapter()

    fragmentMainBinding.articleRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentMainBinding.articleRecyclerView.adapter = articleAdapter
    }

}