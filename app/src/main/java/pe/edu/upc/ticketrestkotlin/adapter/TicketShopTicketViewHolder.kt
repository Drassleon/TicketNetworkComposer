package pe.edu.upc.ticketrestkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import pe.edu.upc.ticketrestkotlin.R

class TicketShopTicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val idTicketShopTicket = itemView.findViewById(R.id.tvTicketShopTicketId) as TextView
    val btnTicketDetails = itemView.findViewById(R.id.btnTicketShopTicketDetails) as Button
}