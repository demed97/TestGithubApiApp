package com.android.dan.testgithubapiapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.data.entity.GitRepositoryEntity
import com.android.dan.testgithubapiapp.databinding.RepositoryItemBinding
import com.android.dan.testgithubapiapp.presentation.utils.DiffUtilCallback
import javax.inject.Inject

class RepositoriesAdapter @Inject constructor() :
    RecyclerView.Adapter<RepositoriesAdapter.RepositoriesHolder>() {

    private var repositoryEntityList: List<GitRepositoryEntity> = arrayListOf()

    fun updateRepositoryList(newRepositoryEntityList: List<GitRepositoryEntity>) {
        val diffUtilCallback = DiffUtilCallback(this.repositoryEntityList, newRepositoryEntityList)
        val result = DiffUtil.calculateDiff(diffUtilCallback)
        this.repositoryEntityList = newRepositoryEntityList
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
        holder.repositoryItemBinding.repository = repositoryEntityList[position]
    }

    override fun getItemCount(): Int {
        return repositoryEntityList.size
    }

    class RepositoriesHolder(var repositoryItemBinding: RepositoryItemBinding) :
        RecyclerView.ViewHolder(repositoryItemBinding.root)
}