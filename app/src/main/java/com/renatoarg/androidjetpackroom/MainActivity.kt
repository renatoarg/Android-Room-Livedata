package com.renatoarg.androidjetpackroom

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.renatoarg.androidjetpackroom.room.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyAdapter.MyDeleteListener {

    private lateinit var adapter: MyAdapter

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeList()
        setupRecyclerView()
        setupButton()
    }

    private fun setupButton() {
        button.setOnClickListener { addUser() }
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(this)
        recyclerView.adapter = adapter
    }

    private fun addUser() {
        mainViewModel.addUser(editText.text.toString(), editText2.text.toString())
        editText.text.clear()
        editText2.text.clear()
    }

    override fun onDelete(user: User) {
        mainViewModel.deleteUser(user)
    }
    private fun observeList() { mainViewModel.getAllUsers().observe(this, Observer { value ->
            adapter.setUsers(value as ArrayList<User>)})
    }

}