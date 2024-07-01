package com.example.contactme.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "users")
data class User(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "userId") @NotNull var userId:Int,
                   @ColumnInfo(name = "userName") @NotNull var userName:String,
                   @ColumnInfo(name = "userTel") @NotNull var userTel:String) {
}