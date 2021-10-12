package com.example.linah_alkhurayyif_headsup

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.celebrities.view.*

class CelebritiesAdapter(private val celebritiesInfo: ArrayList<CelebritiesInfo>): RecyclerView.Adapter<CelebritiesAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.celebrities,
                parent,
                false ))}
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val celebritie = celebritiesInfo[position]
        holder.itemView.apply {
            name_tv.text = celebritie.name
            taboo1_tv.text = "Taboo1: ${celebritie.taboo1}"
            taboo2_tv.text ="Taboo2: ${celebritie.taboo2}"
            taboo3_tv.text ="Taboo3: ${celebritie.taboo3}"
            del.setOnClickListener {
                val intent = Intent(context, Del_Celebritie::class.java)
                intent.putExtra("User_Id", celebritie.pk)
                context.startActivity(intent)
            }
            update.setOnClickListener {
                val intent = Intent(context, Upd_Celebritie::class.java)
                intent.putExtra("Celebritie_Id", celebritie.pk)
                intent.putExtra("Celebritie_Name",celebritie.name)
                intent.putExtra("Taboo1",celebritie.taboo1)
                intent.putExtra("Taboo2",celebritie.taboo2)
                intent.putExtra("Taboo3",celebritie.taboo3)
                context.startActivity(intent)
            }
        }
    }
    override fun getItemCount() = celebritiesInfo.size
}