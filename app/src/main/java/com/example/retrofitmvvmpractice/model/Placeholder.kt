package com.example.retrofitmvvmpractice.model

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
    val website:String?
) {
}