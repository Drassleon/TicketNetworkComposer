package pe.edu.upc.ticketrestkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import pe.edu.upc.ticketrestkotlin.R

class TicketClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val idTicketClient = itemView.findViewById(R.id.tvTicketClientId) as TextView
    val btnTicketDetails = itemView.findViewById(R.id.btnTicketDetails) as Button
}