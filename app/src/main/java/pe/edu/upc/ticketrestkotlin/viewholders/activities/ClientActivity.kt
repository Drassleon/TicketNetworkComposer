package pe.edu.upc.ticketrestkotlin.viewholders.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Address
import pe.edu.upc.ticketrestkotlin.models.Client
import java.time.LocalDate
import java.util.*

class ClientActivity : AppCompatActivity() {

    private lateinit var client : Client
    private lateinit var tvClientID : TextView
    private lateinit var tvClientFirstName : TextView
    private lateinit var tvClientLastName : TextView
    private lateinit var tvClientAddress : TextView
    private lateinit var tvClientIDoc : TextView
    private lateinit var tvClientBirthDate : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        client = Client()
        client.clientId=intent.extras.getString("clientId")
        client.firstName=intent.extras.getString("firstName")
        client.lastName = intent.extras.getString("lastName")
        client.address= Address().fromBundle(intent.extras.getBundle("address"))
        client.id = intent.extras.getString("id")

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
        tvClientBirthDate.text = parseBirthDate(intent.extras.getString("birthDate"))
        tvClientIDoc.text = client.id

    }
    private fun parseBirthDate(unparsed : String) : String{
        var array = unparsed.split(" ")
        return array[2]+"/"+array[1]+"/"+array[5]
    }
}
