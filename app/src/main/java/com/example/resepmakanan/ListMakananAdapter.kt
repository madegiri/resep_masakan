package com.example.resepmakanan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMakananAdapter(private val listMakanan: ArrayList<Makanan>) : RecyclerView.Adapter<ListMakananAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    interface OnItemClickCallback {
        fun onItemClicked(data: Makanan)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_makanan, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listMakanan[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(listMakanan[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listMakanan.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}
