package com.example.hola_mundo_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// extiende o hereda de recyclerview
class ContactAdapter(private val contactList: List<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // definir el componente que se va a repetir
        // siempre referenciar a layoutInflater
        val layoutInflater = LayoutInflater.from(parent.context)
        //  crear paramentro en el contactviewolder
        return ContactViewHolder(layoutInflater.inflate(R.layout.item_contact, parent, false))
    }

    override fun getItemCount(): Int {
        // cantidad de elementos a renderizar
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contactList[position]
        // holder es contactviewholder
        holder.render(item)
    }


    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Dando valores al item_contact.xml - la view hace referencia al item_contact
        val name = view.findViewById<TextView>(R.id.textViewName)
        val phone = view.findViewById<TextView>(R.id.textViewPhone)

        fun render(contact: Contact) {
            name.text = contact.name
            phone.text = contact.phone

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, name.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

}