package com.example.contactme.presentation.contact_detail

import androidx.lifecycle.ViewModel
import com.example.contactme.data.repository.ContactDaoRepository

class ContactDetailViewModel: ViewModel() {
    private var repo = ContactDaoRepository()

    fun update(id:Int,name:String,tel:String){
        repo.updateContact(id,name,tel)
    }
}