package com.android.dan.testgithubapiapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.presentation.base.BaseActivity
import com.android.dan.testgithubapiapp.presentation.main.list.RepositoriesFragment
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showRepositoriesFragment()
    }

    private fun showRepositoriesFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainFragmentContainer, RepositoriesFragment.newInstance())
            .commit()
    }
}