package pe.edu.upc.ticketrestkotlin.viewholders.activities

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.models.Address
import pe.edu.upc.ticketrestkotlin.models.Client
import pe.edu.upc.ticketrestkotlin.repository.ClientRepository
import pe.edu.upc.ticketrestkotlin.repository.RetrofitRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class ClientFormActivity : AppCompatActivity() {

    private lateinit var textEditClientId : TextInputEditText
    private lateinit var textEditClientFirstName : TextInputEditText
    private lateinit var textEditClientLastName : TextInputEditText
    private lateinit var textEditClientIDoc : TextInputEditText
    private lateinit var textEditClientBirthDate : TextInputEditText
    private lateinit var createClientButton : Button
    private lateinit var cancelButton : Button

    private var retrofit = RetrofitRepository().getRetrofitInstance()
    private var clientRepo = retrofit.create(ClientRepository::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.client_form)

        textEditClientId = findViewById(R.id.tiClientIdForm)
        textEditClientFirstName = findViewById(R.id.tiClientFirstNameForm)
        textEditClientLastName = findViewById(R.id.tiClientLastNameForm)
        textEditClientBirthDate = findViewById(R.id.tiClientBirthDateForm)
        textEditClientIDoc = findViewById(R.id.tiClientIDocForm)
        createClientButton = findViewById(R.id.btnCreateClientAccept)
        cancelButton = findViewById(R.id.btnCreateClientCancel)

        var dateClickListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            var monthString = (month+1).toString()
            var dayString = dayOfMonth.toString()
            if(month<=9)
            {
                monthString = "0${month+1}"
            }
            if(dayOfMonth<=9)
            {
                dayString = "0$dayOfMonth"
            }
            textEditClientBirthDate.text = SpannableStringBuilder("$year-$monthString-$dayString")
        }
        textEditClientBirthDate.setOnClickListener {
            closeKeyboard()
            var calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR,1990)
            calendar.set(Calendar.MONTH,0)
            calendar.set(Calendar.DAY_OF_MONTH,1)
            val dialog = DatePickerDialog(this,dateClickListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))
            dialog.show()
        }

        createClientButton.setOnClickListener {
            closeKeyboard()
            var address = Address()
            address.street = "Oswaldo Hercelles 234"
            address.city = "Lima"
            address.country = "Peru"
            address.`$class` = "org.ticket.network.Address"

            var client = Client()
            client.`$class` = "org.ticket.network.Client"
            client.clientId = textEditClientId.text.toString()
            client.firstName = textEditClientFirstName.text.toString()
            client.lastName = textEditClientLastName.text.toString()
            client.docType = "DNI"
            client.id = textEditClientIDoc.text.toString()
            client.address = address
            client.birthdate = textEditClientBirthDate.text.toString()

            var ticketList : MutableList<String> = mutableListOf()
            client.ticketBought = ticketList

            clientRepo.postClient(client).enqueue(object: Callback<Client> {
                override fun onResponse(call: Call<Client>, response: Response<Client>) {
                    Snackbar.make(it,"Client Created Successfully!",Snackbar.LENGTH_SHORT).show()
                    finish()
                }

                override fun onFailure(call: Call<Client>, t: Throwable) {
                    Toast.makeText(this@ClientFormActivity,"Could not persist Client User",Toast.LENGTH_SHORT).show()
                }
            })

        }
        cancelButton.setOnClickListener {
            finish()
        }

    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
