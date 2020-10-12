package com.android.dan.testgithubapiapp.presentation.search.searchfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.data.entity.GitRepositoryEntity
import com.android.dan.testgithubapiapp.databinding.FragmentSearchBinding
import com.android.dan.testgithubapiapp.presentation.base.BaseFragment
import com.android.dan.testgithubapiapp.presentation.adapter.RepositoriesAdapter
import com.android.dan.testgithubapiapp.presentation.adapter.RepositoriesPagedListAdapter
import com.android.dan.testgithubapiapp.presentation.utils.observer
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment : BaseFragment<SearchViewModel>(R.layout.fragment_search) {

//    @Inject
//    lateinit var adapter: RepositoriesAdapter

    val adapter = RepositoriesPagedListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()

    }

    override fun subscribe() {
        super.subscribe()
        viewModel.searchRepositoriesLiveData.observer(this) {
            updateRecyclerView(it)
        }
        viewModel.repos.observer(this) {
            adapter.submitList(it)
        }
    }

    private fun updateRecyclerView(list: List<GitRepositoryEntity>) {
        if (list.isEmpty()) {
            Toast.makeText(context, getString(R.string.not_found), Toast.LENGTH_LONG).show()
        }
//        adapter.submitList(list!!)
        searchRepoRecyclerView.scrollToPosition(0)
    }

    private fun initBinding() {
        val repoBinding =
            DataBindingUtil.setContentView<FragmentSearchBinding>(
                requireActivity(),
                R.layout.fragment_search
            )
        repoBinding.searchViewModel = viewModel
        repoBinding.adapter = adapter
    }

    companion object {

        fun newInstance() = SearchFragment()
    }
}