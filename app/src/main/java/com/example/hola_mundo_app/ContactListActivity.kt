package com.example.hola_mundo_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class ContactListActivity : AppCompatActivity() {
    // El recyclerview se trabaja con la data, el adaptador y viewholder.
    lateinit var recyclerView: RecyclerView
    lateinit var dataModelArrList: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val contacts = listOf<Contact>(
            Contact("Sebastian","9898234234"),
            Contact("Maria","9898234234"),
            Contact("Juan Diego","91152234"),
        )

        // REFERENCIA A ACTIVITYCONTACTLIST -> xml
        // val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        // recyclerView = findViewById(R.id.recyclerViewContact)
        // recyclerView.layoutManager = LinearLayoutManager(this)
        // recyclerView.adapter = ContactAdapter(contacts)



        // INICIALIZANDO EL ARREGLO
        dataModelArrList = ArrayList()

        // PETICION HTTP
        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/users"

        // Request a string response from the provided URL.
        val jsonRequest = JsonArrayRequest(url,
            { // RESPONSE.LISTENER
                response ->
                    // Log.i("Volley", "response: $response")},
                    // textViewTitle.text = "Response is: ${response}"},
                    for ( i in 0 until response.length()) {
                        val item = response.getJSONObject(i)
                        dataModelArrList.add(
                            Contact( item.get("name").toString(), item.get("phone").toString() )
                        )
                    }
                    recyclerView = findViewById(R.id.recyclerViewContact)
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.adapter = ContactAdapter(dataModelArrList)
            },
            { // ERROR.LISTENER
                error -> error.printStackTrace()
                // textViewTitle.text = "That didn't work!"
            }
        )

        // Add the request to the RequestQueue.
        queue.add(jsonRequest)

    }
}