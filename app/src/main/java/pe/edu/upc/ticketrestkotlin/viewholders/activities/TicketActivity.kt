package pe.edu.upc.ticketrestkotlin.viewholders.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_ticket.*
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Ticket

class TicketActivity : AppCompatActivity() {

    private lateinit var ticket : Ticket
    private lateinit var tvTicketId : TextView
    private lateinit var tvticketValue : TextView
    private lateinit var tvTicketAddress : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        ticket = intent.extras.getSerializable("ticket") as Ticket

        tvTicketId = findViewById(R.id.tvTicketId)
        tvticketValue = findViewById(R.id.tvTicketValue)
        tvTicketAddress = findViewById(R.id.tvTicketFestival)

        tvTicketId.text = ticket.ticketId
        tvTicketValue.text = ticket.value.toString()
        tvTicketAddress.text = "${ticket.festival.address.street}-${ticket.festival.address.city}-${ticket.festival.address.country}"

    }
}
