package pe.edu.upc.ticketrestkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import pe.edu.upc.ticketrestkotlin.R


class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val idTextView = itemView.findViewById(R.id.tvTicketProfile) as TextView
    val imgProfile = itemView.findViewById(R.id.imgTicketEvent) as ImageView

}