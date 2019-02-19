package pe.edu.upc.ticketrestkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pe.edu.upc.ticketrestkotlin.R


class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val idTextView = itemView.findViewById(R.id.tvTicketId) as TextView
    val valueTextView = itemView.findViewById(R.id.tvTicketValue) as TextView
    val festivalTextView = itemView.findViewById(R.id.tvTicketFestival) as TextView

}