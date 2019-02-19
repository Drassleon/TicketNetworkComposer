package pe.edu.upc.ticketrestkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import pe.edu.upc.ticketrestkotlin.R

class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val idTextView = itemView.findViewById(R.id.tvClientId) as TextView
    val profileImageView = itemView.findViewById(R.id.imgClientProfile) as ImageView
    /*val firstNameTextView = itemView.findViewById(R.id.tvFirstName) as TextView
    val lastNameTextView = itemView.findViewById(R.id.tvLastName) as TextView
    val addressTextView = itemView.findViewById(R.id.tvAddress) as TextView
    val identificationDocTextView = itemView.findViewById(R.id.tvIdentificationDoc) as TextView
    val birthDateTextView = itemView.findViewById(R.id.tvBirthDate) as TextView*/

}