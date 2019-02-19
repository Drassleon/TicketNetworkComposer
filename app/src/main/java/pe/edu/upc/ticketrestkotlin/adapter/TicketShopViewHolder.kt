package pe.edu.upc.ticketrestkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pe.edu.upc.ticketrestkotlin.R

class TicketShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val idTextView = itemView.findViewById(R.id.tvTicketShopId) as TextView
    val addressTextView = itemView.findViewById(R.id.tvTicketShopAddress) as TextView

}