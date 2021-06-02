package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateDestinationRequest(@SerializedName("id")
                                    @Expose var id: String,
                                    @SerializedName("isCloser")
                                    @Expose var isCloser: Boolean,
                                    @SerializedName("splitDistance")
                                    @Expose var splitDistance: String,
                                    @SerializedName("userid")
                                    @Expose var userid: String,
                                    @SerializedName("token")
                                    @Expose var token: String,
                                    @SerializedName("app_version")
                                    @Expose var app_version: Int,
                                    @SerializedName("_userid")
                                    @Expose var _userid: String

)

