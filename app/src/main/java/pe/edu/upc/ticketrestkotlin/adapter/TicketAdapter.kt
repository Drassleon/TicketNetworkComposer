package pe.edu.upc.ticketrestkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Ticket

class TicketAdapter(var list: List<Ticket>) : RecyclerView.Adapter<TicketViewHolder>() {
    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.idTextView.text = list[position].ticketId
        holder.festivalTextView.text = list[position].festival.address.street+" - "+list[position].festival.address.city+" - "+list[position].festival.address.country
        holder.valueTextView.text = list[position].value.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_view_holder, parent, false)
        return TicketViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}