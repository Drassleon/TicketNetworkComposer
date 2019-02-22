package pe.edu.upc.ticketrestkotlin.viewholders.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.adapter.TicketShopTicketAdapter
import pe.edu.upc.ticketrestkotlin.models.Ticket
import pe.edu.upc.ticketrestkotlin.models.TicketShop
import pe.edu.upc.ticketrestkotlin.repository.RetrofitRepository
import pe.edu.upc.ticketrestkotlin.repository.TicketRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TicketShopActivity : AppCompatActivity() {

    private lateinit var tvTicketShopId : TextView
    private lateinit var tvTicketShopAddress : TextView
    private lateinit var ticketShop : TicketShop
    private lateinit var rvTicketShopTicket : RecyclerView
    private lateinit var tvNoTickets : TextView
    private lateinit var ticketShopTicketAdapter : RecyclerView.Adapter<*>
    private lateinit var ticketShopTicketLayoutManager : RecyclerView.LayoutManager
    private var ticketList: MutableList<Ticket> = mutableListOf()
    private val retrofit = RetrofitRepository().getRetrofitInstance()
    private val ticketRepo: TicketRepository = retrofit.create(TicketRepository::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_shop)

        tvTicketShopId = findViewById(R.id.tvTicketShopId)
        tvTicketShopAddress = findViewById(R.id.tvTicketShopAddress)
        tvNoTickets = findViewById(R.id.tvNoTicketsTicketShop)
        ticketShop = intent.extras?.getSerializable("ticketShop") as TicketShop

        tvTicketShopId.text = ticketShop.shopId
        tvTicketShopAddress.text ="${ticketShop.shopAddress.street}-${ticketShop.shopAddress.city}-${ticketShop.shopAddress.country}"

        if(ticketShop.soldTickets!=null)
        {
            parseTickets(ticketShop.soldTickets)

            rvTicketShopTicket = findViewById(R.id.rvTicketShopTicket)
            ticketShopTicketAdapter = TicketShopTicketAdapter(ticketList)
            ticketShopTicketLayoutManager = LinearLayoutManager(this)
            rvTicketShopTicket.adapter = ticketShopTicketAdapter
            rvTicketShopTicket.layoutManager = ticketShopTicketLayoutManager
        }
        if(ticketList.isEmpty())
        {
            tvNoTickets.visibility = View.VISIBLE
        }
        else
        {
            tvNoTickets.visibility = View.GONE
        }
    }

    private fun parseTickets(unparse: List<String>) {
        var ticket : Ticket
        for (ticketString in unparse)
        {
            var ticketIdString = ticketString.split("#")

            var ticketCall : Call<Ticket> = ticketRepo.getTicket(ticketIdString[1])
            ticketCall.enqueue(object : Callback<Ticket> {
                override fun onResponse(call: Call<Ticket>, response: Response<Ticket>) {
                    ticket = response.body() as Ticket
                    ticketList.add(ticket)
                    ticketShopTicketAdapter.notifyDataSetChanged()
                    if(ticketList.isNotEmpty())
                    {
                        tvNoTickets.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<Ticket>, t: Throwable) {
                    Toast.makeText(this@TicketShopActivity,"Could not load Ticket Data $ticketString for Client: ${ticketShop.shopId}",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
