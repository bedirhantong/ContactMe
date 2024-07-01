package com.example.contactme.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactme.entitiy.User
import com.example.contactme.data.repository.ContactDaoRepository

class HomeViewModel:ViewModel() {
    private var repo = ContactDaoRepository()
    var contactList  = MutableLiveData<List<User>>()

    init {
        getAllContacts()
        contactList = repo.getContacts()
    }

    fun getAllContacts(){
        repo.allContact()
    }

    fun search(searchContent : String){
        repo.searchContact(searchContent)
    }

    fun delete(id:Int){
        repo.deleteContact(id)
    }

}