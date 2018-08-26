package com.renatoarg.androidjetpackroom

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.renatoarg.androidjetpackroom.room.User
import kotlinx.android.synthetic.main.row_my_custom_view.view.*

class MyAdapter(private var context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id = itemView.tv_id_value!!
        val name = itemView.tv_name_value!!
        val desc = itemView.tv_desc_value!!
        val delete = itemView.imageButton!!
    }

    interface MyDeleteListener {
        fun onDelete(user: User)
    }

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var mUsers: List<User>
    private var myDeleteListener: MyDeleteListener = context as MyDeleteListener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_my_custom_view, p0, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        if (mUsers != null) {
            p0.id.text = mUsers!![p1].id.toString()
            p0.name.text = mUsers!![p1].name.toString()
            p0.desc.text = mUsers!![p1].description.toString()
            p0.delete.setOnClickListener { myDeleteListener.onDelete(mUsers[p1])}
        }
    }

    override fun getItemCount(): Int {
        return if (mUsers == null)
            0
        else
            mUsers.size

    }

    fun setUsers(users: List<User>) {
        mUsers = users
        notifyDataSetChanged()
    }


}
