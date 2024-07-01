package com.example.contactme.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.contactme.R
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController){

    val viewmodel: HomeViewModel = viewModel()
    val users = viewmodel.contactList.observeAsState(listOf())


    val isSearching = remember {
        mutableStateOf(false)
    }

    val searchResult = remember {
        mutableStateOf("")
    }



    Scaffold (
        topBar = {
            TopAppBar(
                title = {

                    if(isSearching.value){
                        TextField(
                            value = searchResult.value,
                            onValueChange = {
                                searchResult.value = it
                                viewmodel.search(it)
                            },
                            label = { Text(text = "Kişi Ara") },
                            colors = TextFieldDefaults.colors(
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                            )
                        )
                    }else{
                        Text(text = "Contacts")
                    }
                },
                actions = {

                    if(isSearching.value){
                        IconButton(
                            onClick = {
                                isSearching.value  = false
                                // degeri temizledim
                                searchResult.value = ""
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.close_image),
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    }else{
                        IconButton(
                            onClick = {
                                isSearching.value = true
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.search_image),
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    }
                }
            )
        },
        content = {
            LazyColumn (
                modifier = Modifier.padding(top = 100.dp)
            ){
                items(
                    count = users.value!!.count(),
                    itemContent = {
                        val user = users.value!![it]
                        Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Row (
                                modifier = Modifier.clickable {
                                    val userJson = Gson().toJson(user)
                                    navController.navigate("userDetail/${userJson}")
                                }
                            ){
                                Row(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ){
                                    Text(text = "${user.userName} - ${user.userTel}")
                                    IconButton(onClick = {
                                        viewmodel.delete(user.userId)
//                                        users.remove(user)
                                    }) {
                                        Icon(painter = painterResource(id = R.drawable.delete_image),
                                            contentDescription = "",tint = Color.Gray)
                                    }
                                }
                            }
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("userRegister")
                },
                contentColor = colorResource(id = R.color.teal_700),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.add_image),
                        contentDescription = "",
                        tint = Color.White
                    )
                },

                )

        }
    )
}
