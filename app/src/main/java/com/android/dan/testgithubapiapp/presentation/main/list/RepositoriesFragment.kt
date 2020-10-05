package com.android.dan.testgithubapiapp.presentation.main.list

import android.os.Bundle
import android.view.View
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.presentation.base.BaseFragment
import javax.inject.Inject

class RepositoriesFragment :
    BaseFragment<RepositoriesViewModel>(R.layout.fragment_repositories_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showProgressBar()
    }

    companion object {
        fun newInstance() = RepositoriesFragment()
    }
}