package com.android.dan.testgithubapiapp.presentation.main.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.data.entity.GitRepository
import com.android.dan.testgithubapiapp.databinding.RepositoryItemBinding
import com.android.dan.testgithubapiapp.presentation.utils.DiffUtilCallback
import javax.inject.Inject

class RepositoriesAdapter @Inject constructor() :
    RecyclerView.Adapter<RepositoriesAdapter.RepositoriesHolder>() {

    private var repositoryList: List<GitRepository> = arrayListOf()

    fun updateRepositoryList(newRepositoryList: List<GitRepository>) {
        val diffUtilCallback = DiffUtilCallback(this.repositoryList, newRepositoryList)
        val result = DiffUtil.calculateDiff(diffUtilCallback)
        this.repositoryList = newRepositoryList
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val repositoryItemBinding: RepositoryItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.repository_item,
            parent,
            false
        )
        return RepositoriesHolder(repositoryItemBinding)
    }

    override fun onBindViewHolder(holder: RepositoriesHolder, position: Int) {
        holder.repositoryItemBinding.repository = repositoryList[position]
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }

    class RepositoriesHolder(var repositoryItemBinding: RepositoryItemBinding) :
        RecyclerView.ViewHolder(repositoryItemBinding.root)
}