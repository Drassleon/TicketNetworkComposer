package pe.edu.upc.ticketrestkotlin.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.TicketShop
import pe.edu.upc.ticketrestkotlin.viewholders.activities.TicketShopActivity


class TicketShopAdapter(var list: List<TicketShop>) : RecyclerView.Adapter<TicketShopViewHolder>() {
    override fun onBindViewHolder(holder: TicketShopViewHolder, position: Int) {
        holder.tvTicketShopId.text = list[position].shopId
        holder.imgTicketShopProfile.setOnClickListener {
            it.context.startActivity(Intent(it.context,TicketShopActivity::class.java).putExtra("ticketShop",list[position]))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketShopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_shop_view_holder, parent, false)
        return TicketShopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}