package com.example.retrofitmvvmpractice.model

import com.example.retrofitmvvmpractice.dummy.Address
import com.example.retrofitmvvmpractice.dummy.Geo
import com.google.gson.annotations.SerializedName

data class Placeholder(
    @SerializedName("name")
    val name: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("phone")
    val phone:String?,
    @SerializedName("website")
    val website:String?,
    @SerializedName("address")
    val address: Address
) {
}

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String
)