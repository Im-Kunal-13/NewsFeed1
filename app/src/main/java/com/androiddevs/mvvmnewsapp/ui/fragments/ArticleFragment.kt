package com.androiddevs.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.ui.NewsActivity
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel

class ArticleFragment: Fragment(R.layout.fragment_article) {
    // creating a lateinit var instance of NewsViewModel.
    lateinit var viewModel: NewsViewModel

    // Overriding onViewCreated function.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Casting the activity as NewsActivity and getting the viewModel of it.
        viewModel = (activity as NewsActivity).viewModel
    }
}