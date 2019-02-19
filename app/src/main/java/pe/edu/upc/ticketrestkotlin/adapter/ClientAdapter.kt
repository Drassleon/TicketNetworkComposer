package pe.edu.upc.ticketrestkotlin.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Client
import pe.edu.upc.ticketrestkotlin.viewholders.activities.ClientActivity


class ClientAdapter(var list: List<Client>) : RecyclerView.Adapter<ClientViewHolder>() {
    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.idTextView.text = list[position].clientId
        holder.profileImageView.setOnClickListener{
            val context = it.context
            context.startActivity(Intent(context,ClientActivity::class.java).putExtras(list[position].toBundle()))
        }
        /*holder.firstNameTextView.text = list[position].firstName
        holder.lastNameTextView.text = list[position].lastName
        holder.addressTextView.text = list[position].address.street+" - "+list[position].address.city+" - "+list[position].address.country
        holder.identificationDocTextView.text = list[position].docType+' '+list[position].id
        holder.birthDateTextView.text = list[position].birthdate.toString()
*/
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.client_view_holder, parent, false)
        return ClientViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}