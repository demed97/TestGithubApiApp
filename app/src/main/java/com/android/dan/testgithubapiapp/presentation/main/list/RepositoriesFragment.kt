package com.android.dan.testgithubapiapp.presentation.main.list

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.databinding.FragmentRepositoriesListBinding
import com.android.dan.testgithubapiapp.presentation.base.BaseFragment
import com.android.dan.testgithubapiapp.presentation.utils.observer
import javax.inject.Inject

class RepositoriesFragment :
    BaseFragment<RepositoriesViewModel>(R.layout.fragment_repositories_list) {

    @Inject
    lateinit var adapter: RepositoriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadRepositories()
        initBinding()
    }

    private fun initBinding() {
        val repoBinding =
            DataBindingUtil.setContentView<FragmentRepositoriesListBinding>(
                requireActivity(),
                R.layout.fragment_repositories_list
            )
        repoBinding.adapter = adapter
    }

    override fun subscribe() {
        super.subscribe()
        viewModel.repositoriesLiveData.observer(this) {
            adapter.updateRepositoryList(it)
        }
    }

    companion object {
        fun newInstance() = RepositoriesFragment()
    }
}