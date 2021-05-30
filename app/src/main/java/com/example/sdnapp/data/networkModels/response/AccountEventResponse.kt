package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AccountEventResponse(@SerializedName("result")
                                    @Expose var result: String)
