package com.example.challenge3binar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class Adapaters(private val listMenu: ArrayList<DataMenu>)
    : RecyclerView.Adapter<Adapaters.ViewHolder>(){

    var onItemClick : ((DataMenu) -> Unit)? = null

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val gambar = itemView.findViewById<ImageView>(R.id.iv_gambar)
        val namaMenu = itemView.findViewById<TextView>(R.id.tv_namaMenu)
        val hargaMenu = itemView.findViewById<TextView>(R.id.tv_hargaMenu)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_menu_linear, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = listMenu[position]
        holder.gambar.setImageResource(menu.img)
        holder.namaMenu.text = menu.nameMenu
        holder.hargaMenu.text = menu.hargaMenu

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(menu)
        }
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
}


