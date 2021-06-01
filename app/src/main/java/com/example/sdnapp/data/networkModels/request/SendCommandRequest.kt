package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SendCommandRequest(@SerializedName("sensorid")
                              @Expose
                              var sensorid: String,
                              @SerializedName("segid")
                              @Expose
                              var segid: String,
                              @SerializedName("command")
                              @Expose
                              var command: String,
                              @SerializedName("userid")
                              @Expose
                              var userid: String,
                              @SerializedName("token")
                              @Expose
                              var token: String,
                              @SerializedName("app_version")
                              @Expose
                              var appVersion: Int,
                              @SerializedName("_userid")
                              @Expose var _userid: String)
