package pe.edu.upc.ticketrestkotlin.viewholders.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Address
import pe.edu.upc.ticketrestkotlin.models.Client
import pe.edu.upc.ticketrestkotlin.models.Ticket
import pe.edu.upc.ticketrestkotlin.repository.ClientRepository
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
    private lateinit var recyclerViewTickets : RecyclerView
    private lateinit var ticketList: List<Ticket>
    private val retrofit = RetrofitRepository().getRetrofitInstance()
    private val ticketRepo: TicketRepository = retrofit.create(TicketRepository::class.java)
    private val clientRepo : ClientRepository = retrofit.create(ClientRepository::class.java)


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

        tvClientID.text = client.clientId
        tvClientFirstName.text = client.firstName
        tvClientLastName.text = client.lastName
        tvClientAddress.text = client.address.street+"-"+client.address.city+"-"+client.address.country
        tvClientBirthDate.text = parseBirthDate(client.birthdate.toString())
        tvClientIDoc.text = client.id


        if(client.ticketBought!=null)
        ticketList = parseTickets(client.ticketBought)
    }
    private fun parseBirthDate(unparsed : String) : String{
        var array = unparsed.split(" ")
        return array[2]+"/"+array[1]+"/"+array[5]
    }
    private fun parseTickets(unparse: List<String>) :List<Ticket>{
        var ticket : Ticket
        var ticketList : ArrayList<Ticket> = ArrayList()
        for (ticketString in unparse)
        {
            var ticketIdString = ticketString.split("#")
            var ticketCall : Call<Ticket> = ticketRepo.getTicket(ticketIdString[1])
            ticketCall.enqueue(object : Callback<Ticket>{
                override fun onResponse(call: Call<Ticket>, response: Response<Ticket>) {
                    ticket = response.body() as Ticket
                    ticketList.add(ticket)
                }

                override fun onFailure(call: Call<Ticket>, t: Throwable) {
                    Toast.makeText(this@ClientActivity,"Could not load Ticket Data $ticketString for Client: ${client.id}",Toast.LENGTH_SHORT).show()
                }
            })
        }
        return ticketList
    }
}
