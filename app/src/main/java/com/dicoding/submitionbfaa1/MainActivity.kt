package com.dicoding.submitionbfaa1

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : UserAdapter
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var users: ArrayList<UserData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataPhoto = resources.obtainTypedArray(R.array.photo)
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)

        adapter = UserAdapter(this, addItem())
        lv_list.adapter = adapter

        lv_list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _->
            val listDataUser = UserData(0,"","", "", "", "", "")
            listDataUser.photo = dataPhoto.getResourceId(position, position)
            listDataUser.username = dataUsername[position]
            listDataUser.name = dataName[position]
            listDataUser.location = dataLocation[position]
            listDataUser.repository = dataRepository[position]
            listDataUser.followers = dataFollowers[position]
            listDataUser.following = dataFollowing[position]

            val intent = Intent(this@MainActivity, UserDetail::class.java)
            intent.putExtra(UserDetail.EXTRA_DATA, listDataUser)

            this@MainActivity.startActivity(intent)
            Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
        }
    }


    private fun addItem() : ArrayList<UserData> {
        users = ArrayList()
        for (i in dataName.indices) {
            val user = UserData()
            user.photo = dataPhoto.getResourceId(i, -1)
            user.name = dataName[i]
            user.location = dataLocation[i]
            users.add(user)
        }
        return users
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.credit -> {
                val iAbout = Intent(this@MainActivity, Credit::class.java)
                startActivity(iAbout)
            }
        }
    }
}