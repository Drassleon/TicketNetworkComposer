package pe.edu.upc.ticketrestkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import pe.edu.upc.ticketrestkotlin.R

class TicketShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvTicketShopId = itemView.findViewById(R.id.tvTicketShopProfile) as TextView
    val imgTicketShopProfile = itemView.findViewById(R.id.imgTicketShop) as ImageView
}