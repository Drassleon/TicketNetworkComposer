package pe.edu.upc.ticketrestkotlin.viewholders.activities

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Address
import pe.edu.upc.ticketrestkotlin.models.TicketShop
import pe.edu.upc.ticketrestkotlin.repository.RetrofitRepository
import pe.edu.upc.ticketrestkotlin.repository.TicketRepository

class TicketShopFormActivity : AppCompatActivity() {

    private lateinit var textEditShopId : TextInputEditText
    private lateinit var textEditShopStreet : TextInputEditText
    private lateinit var textEditShopCity : TextInputEditText
    private lateinit var textEditShopCountry : TextInputEditText
    private lateinit var btnCreateShopAccept : Button
    private lateinit var btnCreateShopCancel : Button

    private var retrofit = RetrofitRepository().getRetrofitInstance()
    private var ticketRepo : TicketRepository = retrofit.create(TicketRepository::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_shop_form)

        textEditShopId = findViewById(R.id.tiTicketShopIdForm)
        textEditShopStreet = findViewById(R.id.tiTicketShopAddressStreetForm)
        textEditShopCity = findViewById(R.id.tiTicketShopAddressCityForm)
        textEditShopCountry = findViewById(R.id.tiTicketShopAddressCountryForm)
        btnCreateShopAccept = findViewById(R.id.btnCreateTicketShopAccept)
        btnCreateShopCancel = findViewById(R.id.btnCreateTicketShopCancel)

        btnCreateShopAccept.setOnClickListener {
            val shop = TicketShop()
            val address = Address()
            val soldTickets: MutableList<String> = mutableListOf()

            shop.`$class` = "org.ticket.network.Address"
            shop.shopId = textEditShopId.text.toString()

            address.`$class`= "org.ticket.network.TicketShop"
            address.street = textEditShopStreet.text.toString()
            address.city = textEditShopCity.text.toString()
            address.country = textEditShopCountry.text.toString()

            shop.soldTickets = soldTickets

        }
        btnCreateShopCancel.setOnClickListener {
            finish()
        }
    }
}
