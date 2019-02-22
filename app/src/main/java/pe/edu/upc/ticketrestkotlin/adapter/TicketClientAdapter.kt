package pe.edu.upc.ticketrestkotlin.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Ticket
import pe.edu.upc.ticketrestkotlin.viewholders.activities.TicketActivity

class TicketClientAdapter(var list: List<Ticket>) : RecyclerView.Adapter<TicketClientViewHolder>() {
    override fun onBindViewHolder(holder: TicketClientViewHolder, position: Int) {
        holder.idTicketClient.text = list[position].ticketId
        holder.btnTicketDetails.setOnClickListener {
            it.context.startActivity(Intent(it.context,TicketActivity::class.java).putExtra("ticket",list[position]))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketClientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.client_tickets_details_view_holder, parent, false)
        return TicketClientViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}