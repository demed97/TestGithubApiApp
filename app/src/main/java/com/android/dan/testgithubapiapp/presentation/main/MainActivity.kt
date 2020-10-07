package com.android.dan.testgithubapiapp.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.presentation.auth.AuthActivity
import com.android.dan.testgithubapiapp.presentation.base.BaseActivity
import com.android.dan.testgithubapiapp.presentation.main.list.RepositoriesFragment

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = intent.getParcelableExtra<User>(RepositoriesFragment.KEY_USER)
        showRepositoriesFragment(user)
        setVisibilityBackButton()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            android.R.id.home -> {
                if (supportFragmentManager.backStackEntryCount == 0) {
                    startActivity(Intent(this, AuthActivity::class.java))
                    finish()
                } else {
                    onBackPressed()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setVisibilityBackButton() {
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun showRepositoriesFragment(user: User) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFragmentContainer, RepositoriesFragment.newInstance(user))
            .commit()
    }
}