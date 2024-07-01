package com.example.contactme.presentation.contact_register

import androidx.lifecycle.ViewModel
import com.example.contactme.data.repository.ContactDaoRepository

class ContactRegisterViewModel: ViewModel() {
    private var repo = ContactDaoRepository()


    fun register(name:String,tel:String){
        repo.registerContact(name,tel)
    }
}