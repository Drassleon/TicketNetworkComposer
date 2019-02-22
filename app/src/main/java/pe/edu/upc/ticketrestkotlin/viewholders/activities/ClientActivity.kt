package pe.edu.upc.ticketrestkotlin.viewholders.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.adapter.TicketClientAdapter
import pe.edu.upc.ticketrestkotlin.models.Client
import pe.edu.upc.ticketrestkotlin.models.Ticket
import pe.edu.upc.ticketrestkotlin.repository.RetrofitRepository
import pe.edu.upc.ticketrestkotlin.repository.TicketRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ClientActivity : AppCompatActivity() {

    private lateinit var client : Client
    private lateinit var tvClientID : TextView
    private lateinit var tvClientFirstName : TextView
    private lateinit var tvClientLastName : TextView
    private lateinit var tvClientAddress : TextView
    private lateinit var tvClientIDoc : TextView
    private lateinit var tvClientBirthDate : TextView
    private lateinit var tvNoTickets : TextView

    private lateinit var ticketRecyclerView : RecyclerView
    private lateinit var ticketAdapter : RecyclerView.Adapter<*>
    private lateinit var ticketLayoutManager : RecyclerView.LayoutManager


    private var ticketList: MutableList<Ticket> = mutableListOf()
    private val retrofit = RetrofitRepository().getRetrofitInstance()
    private val ticketRepo: TicketRepository = retrofit.create(TicketRepository::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        client= Client()

        client = intent.extras.getSerializable("client") as Client

        tvClientID=findViewById(R.id.tvClientId)
        tvClientFirstName = findViewById(R.id.tvFirstName)
        tvClientLastName = findViewById(R.id.tvLastName)
        tvClientAddress = findViewById(R.id.tvAddress)
        tvClientIDoc = findViewById(R.id.tvIdentificationDoc)
        tvClientBirthDate = findViewById(R.id.tvBirthDate)
        tvNoTickets = findViewById(R.id.lblNoTickets)

        tvClientID.text = client.clientId
        tvClientFirstName.text = client.firstName
        tvClientLastName.text = client.lastName
        tvClientAddress.text = client.address.street+"-"+client.address.city+"-"+client.address.country
        tvClientBirthDate.text = parseBirthDate(client.birthdate.toString())
        tvClientIDoc.text = client.id

        if(client.ticketBought!=null)
        {
            parseTickets(client.ticketBought)

            ticketRecyclerView = findViewById(R.id.rvTicketClient)
            ticketAdapter = TicketClientAdapter(ticketList)
            ticketLayoutManager = LinearLayoutManager(this)
            ticketRecyclerView.adapter = ticketAdapter
            ticketRecyclerView.layoutManager = ticketLayoutManager
        }
        if(client.ticketBought.isEmpty())
        {
            tvNoTickets.visibility = View.VISIBLE
        }
        else
        {
            tvNoTickets.visibility = View.GONE
        }


    }
    private fun parseBirthDate(unparsed : String) : String{
        var array = unparsed.split(" ")
        return array[2]+"/"+array[1]+"/"+array[5]
    }
    private fun parseTickets(unparse: List<String>) {
        var ticket : Ticket
        for (ticketString in unparse)
        {
            var ticketIdString = ticketString.split("#")

            var ticketCall : Call<Ticket> = ticketRepo.getTicket(ticketIdString[1])
            ticketCall.enqueue(object : Callback<Ticket>{
                override fun onResponse(call: Call<Ticket>, response: Response<Ticket>) {
                    ticket = response.body() as Ticket
                    ticketList.add(ticket)
                    ticketAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<Ticket>, t: Throwable) {
                    Toast.makeText(this@ClientActivity,"Could not load Ticket Data $ticketString for Client: ${client.id}",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
