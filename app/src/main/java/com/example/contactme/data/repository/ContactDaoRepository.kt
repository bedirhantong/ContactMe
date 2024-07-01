package com.example.contactme.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.contactme.entitiy.User
import com.example.contactme.room.Database

class ContactDaoRepository {
    private var contactList  = MutableLiveData<List<User>>()
    lateinit var db :Database

    init {
        contactList  = MutableLiveData()
    }

    fun getContacts():MutableLiveData<List<User>>{
        return contactList
    }

    fun allContact(){
        val list = mutableListOf<User>()
        val k1 = User(1,"Ahmet","111111")
        val k2 = User(2,"Zeynep","222222")
        list.add(k1)
        list.add(k2)

        contactList.value = list

    }

    fun searchContact(searchContent : String){

    }

    fun registerContact(name:String,tel:String){

    }

    fun updateContact(id:Int,name:String,tel:String){

    }

    fun deleteContact(id:Int){

    }


}