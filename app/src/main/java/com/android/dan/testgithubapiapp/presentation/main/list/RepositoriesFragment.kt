package com.android.dan.testgithubapiapp.presentation.main.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.databinding.FragmentRepositoriesListBinding
import com.android.dan.testgithubapiapp.presentation.adapter.RepositoriesAdapter
import com.android.dan.testgithubapiapp.presentation.base.BaseFragment
import com.android.dan.testgithubapiapp.presentation.search.SearchActivity
import com.android.dan.testgithubapiapp.presentation.search.searchfragment.SearchFragment
import com.android.dan.testgithubapiapp.presentation.utils.observer
import javax.inject.Inject

class RepositoriesFragment :
    BaseFragment<RepositoriesViewModel>(R.layout.fragment_repositories_list) {

    @Inject
    lateinit var adapter: RepositoriesAdapter

    private val user by lazy {
        requireArguments().get(KEY_USER) as User
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadRepositories(user)
        initBinding()
    }

    private fun fabClick() {
        startActivity(Intent(context, SearchActivity::class.java))
    }

    private fun initBinding() {
        val repoBinding = DataBindingUtil.setContentView<FragmentRepositoriesListBinding>(
            requireActivity(),
            R.layout.fragment_repositories_list
        )
        repoBinding.adapter = adapter
        repoBinding.viewModel = viewModel

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, SearchFragment.newInstance())
            .addToBackStack(null)
            .commit()
        return super.onOptionsItemSelected(item)
    }

    override fun subscribe() {
        super.subscribe()
        viewModel.repositoriesLiveData.observer(this) {
            adapter.updateRepositoryList(it)
        }
        viewModel.fabClickEvent.observer(this) {
            fabClick()
        }
    }

    companion object {
        const val KEY_USER = "user"

        fun newInstance(user: User) =
            RepositoriesFragment().apply {
                arguments = bundleOf(KEY_USER to user)
            }
    }
}