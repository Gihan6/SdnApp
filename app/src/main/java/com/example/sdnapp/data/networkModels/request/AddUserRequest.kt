package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddUserRequest(@SerializedName("email")
                          @Expose var email: String,
                          @SerializedName("full_name")
                          @Expose var full_name: String,
                          @SerializedName("password")
                          @Expose var password: String,
                          @SerializedName("mobileno")
                          @Expose var mobileno: String,
                          @SerializedName("mobileok")
                          @Expose var mobileok: Boolean,
                          @SerializedName("email_ok")
                          @Expose var email_ok: Boolean,
                          @SerializedName("country")
                          @Expose var country: String,
                          @SerializedName("user_cat")
                          @Expose var user_cat: String,
                          @SerializedName("token")
                          @Expose var token: String,
                          @SerializedName("userid")
                          @Expose var userid: String,
                          @SerializedName("min_speed")
                          @Expose var min_speed: String,
                          @SerializedName("app_version")
                          @Expose var app_version: String)
