package com.example.hola_mundo_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListActivity : AppCompatActivity() {
    // El recyclerview se trabaja con la data, el adaptador y viewholder.
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val contacts = listOf<Contact>(
            Contact("Sebastian","9898234234"),
            Contact("Maria","9898234234"),
            Contact("Juan Diego","91152234"),
        )

        // hace referencia al activity_contact_list -> xml
        recyclerView = findViewById(R.id.recyclerViewContact)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ContactAdapter(contacts)

    }
}