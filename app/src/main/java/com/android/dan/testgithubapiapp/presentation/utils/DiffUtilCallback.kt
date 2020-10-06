package com.android.dan.testgithubapiapp.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.android.dan.testgithubapiapp.data.entity.GitRepository

class DiffUtilCallback(var oldList: List<GitRepository>, var newList: List<GitRepository>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size


    override fun getNewListSize(): Int = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}