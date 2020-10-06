package com.android.dan.testgithubapiapp.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.presentation.auth.AuthActivity
import com.android.dan.testgithubapiapp.presentation.base.BaseActivity
import com.android.dan.testgithubapiapp.presentation.main.list.RepositoriesFragment
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = intent.getParcelableExtra<User>("user")
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
            .add(R.id.mainFragmentContainer, RepositoriesFragment.newInstance(user))
            .commit()
    }
}