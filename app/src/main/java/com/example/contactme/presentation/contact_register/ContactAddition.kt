package com.example.contactme.presentation.contact_register

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactme.presentation.contact_register.ContactRegisterViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun ContactRegister(){
    val viewmodel: ContactRegisterViewModel = viewModel()


    val userName = remember {
        mutableStateOf("")
    }
    val userTelNo = remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current



    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = "Contact Register") })
        },
        content = {
                  Column(
                      modifier = Modifier.fillMaxSize(),
                      verticalArrangement = Arrangement.SpaceEvenly,
                      horizontalAlignment = Alignment.CenterHorizontally
                  ) {
                      TextField(
                          value = userName.value,
                          onValueChange = {userName.value = it},
                          label = { Text(text = "Kişi Ad")})

                      TextField(
                          value = userTelNo.value,
                          onValueChange = {userTelNo.value = it},
                          label = { Text(text = "Kişi Tel")})

                      Button(onClick = {
                          val name = userName.value
                          val tel = userTelNo.value
                          viewmodel.register(name,tel)

                          localFocusManager.clearFocus()

                      },modifier = Modifier.size(250.dp,50.dp)) {
                          Text(text = "KAYDET")
                      }
                  }
        },
    )
}