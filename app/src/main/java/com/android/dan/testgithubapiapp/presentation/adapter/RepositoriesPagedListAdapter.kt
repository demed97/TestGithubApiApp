package com.android.dan.testgithubapiapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.data.entity.GitRepositoryEntity
import com.android.dan.testgithubapiapp.databinding.RepositoryItemBinding

class RepositoriesPagedListAdapter :
    PagedListAdapter<GitRepositoryEntity, RepositoriesPagedListAdapter.RepositoriesPagedHolder>(
        diffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesPagedHolder {
        val inflater = LayoutInflater.from(parent.context)
        val repositoryItemBinding: RepositoryItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.repository_item,
            parent,
            false
        )
        return RepositoriesPagedHolder(repositoryItemBinding)
    }

    override fun onBindViewHolder(holder: RepositoriesPagedHolder, position: Int) {
        holder.repositoryItemBinding.repository = getItem(position)
    }

    class RepositoriesPagedHolder(var repositoryItemBinding: RepositoryItemBinding) :
        RecyclerView.ViewHolder(repositoryItemBinding.root)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<GitRepositoryEntity>() {
            override fun areItemsTheSame(
                oldItem: GitRepositoryEntity,
                newItem: GitRepositoryEntity
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: GitRepositoryEntity,
                newItem: GitRepositoryEntity
            ): Boolean = oldItem == newItem
        }
    }
}