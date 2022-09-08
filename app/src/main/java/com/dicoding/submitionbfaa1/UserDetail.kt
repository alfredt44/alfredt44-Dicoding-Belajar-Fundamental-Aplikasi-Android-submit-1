package com.dicoding.submitionbfaa1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.user_detail.*

class UserDetail : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)

        val listUser : UserData = intent.getParcelableExtra(EXTRA_DATA)!!

        detail_photo.setImageResource(listUser.photo!!)
        detail_username.text = getString(R.string.username, listUser.username)
        detail_name.text = listUser.name
        detail_location.text = getString(R.string.location, listUser.location)
        detail_repository.text = getString(R.string.repository, listUser.repository)
        detail_followers.text = getString(R.string.followers, listUser.followers)
        detail_following.text = getString(R.string.following, listUser.following)

    }

}