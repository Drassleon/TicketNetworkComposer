package pe.edu.upc.ticketrestkotlin.viewholders.activities

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Address
import pe.edu.upc.ticketrestkotlin.models.TicketShop
import pe.edu.upc.ticketrestkotlin.repository.RetrofitRepository
import pe.edu.upc.ticketrestkotlin.repository.TicketShopRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TicketShopFormActivity : AppCompatActivity() {

    private lateinit var textEditShopId : TextInputEditText
    private lateinit var textEditShopStreet : TextInputEditText
    private lateinit var textEditShopCity : TextInputEditText
    private lateinit var textEditShopCountry : TextInputEditText
    private lateinit var btnCreateShopAccept : Button
    private lateinit var btnCreateShopCancel : Button

    private var retrofit = RetrofitRepository().getRetrofitInstance()
    private var shopRepo : TicketShopRepository = retrofit.create(TicketShopRepository::class.java)

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

            shopRepo.postShop(shop).enqueue(object: Callback<TicketShop>{
                override fun onResponse(call: Call<TicketShop>, response: Response<TicketShop>) {
                    Toast.makeText(this@TicketShopFormActivity,"Ticket Shop created successfully!",Toast.LENGTH_SHORT).show()
                    finish()
                }

                override fun onFailure(call: Call<TicketShop>, t: Throwable) {
                    Toast.makeText(this@TicketShopFormActivity,"Ticket Shop could not be created!",Toast.LENGTH_SHORT).show()
                }
            })
        }
        btnCreateShopCancel.setOnClickListener {
            finish()
        }
    }
}
