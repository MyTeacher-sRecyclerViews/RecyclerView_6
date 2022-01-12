package com.example.rv_inside_nestedscroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rv_inside_nestedscroll.adapter.CustomAdapter
import com.example.rv_inside_nestedscroll.databinding.ActivityMainBinding
import com.example.rv_inside_nestedscroll.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initViews()

        val users = addedUsers()
        refreshAdapter(users)

    }

    private fun initViews() {
        bin.recyclerview.layoutManager = GridLayoutManager(this, 1)
        bin.recyclerview.isNestedScrollingEnabled = false
    }

    private fun addedUsers(): ArrayList<User> {
        val users = ArrayList<User>()

        for (i in 0..30) {
            users.add(User("Android", "$i"))
        }
        return users
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        val adapter = CustomAdapter(this, users)
        bin.recyclerview.adapter = adapter
    }
}