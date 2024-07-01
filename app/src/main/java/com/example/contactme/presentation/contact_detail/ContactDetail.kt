package com.example.contactme.presentation.contact_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactme.entitiy.User
import com.example.contactme.presentation.contact_detail.ContactDetailViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun ContactDetail(user: User){
    val name = remember { mutableStateOf("") }
    val tel = remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    val viewmodel: ContactDetailViewModel = viewModel()

    LaunchedEffect(key1 = true){
        name.value = user.userName
        tel.value = user.userTel
    }




    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = "Contact Detail") })
        },
        content = {
                  Column(
                      modifier = Modifier.fillMaxSize(),
                      verticalArrangement = Arrangement.SpaceEvenly,
                      horizontalAlignment = Alignment.CenterHorizontally
                  ) {
                      TextField(
                          value = name.value,
                          onValueChange = {name.value = it},
                          label = { Text(text = "Kişi Ad") })

                      TextField(
                          value = tel.value,
                          onValueChange = {tel.value = it},
                          label = { Text(text = "Kişi Tel") })
                      Button(onClick = {
                          val nameUpdate = name.value
                          val telUpdate = tel.value
                          viewmodel.update(user.userId,nameUpdate,telUpdate)

                          localFocusManager.clearFocus()

                      },modifier = Modifier.size(250.dp,50.dp)) {
                          Text(text = "GÜNCELLE")
                      }
                  }
        },
    )
}