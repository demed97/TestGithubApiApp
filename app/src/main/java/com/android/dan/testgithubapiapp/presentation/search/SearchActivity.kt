package com.android.dan.testgithubapiapp.presentation.search

import android.os.Bundle
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.presentation.base.BaseActivity
import com.android.dan.testgithubapiapp.presentation.search.searchfragment.SearchFragment

class SearchActivity : BaseActivity<SearchActivityViewModel>(R.layout.activity_search) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showSearchFragment()
    }

    private fun showSearchFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.searchFragmentContainer, SearchFragment.newInstance())
            .commit()
    }
}