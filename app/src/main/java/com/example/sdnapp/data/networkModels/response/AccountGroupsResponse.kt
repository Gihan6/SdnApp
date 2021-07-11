package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.SerializedName

data class AccountGroupsResponse(
    @SerializedName("type") val type: String,
    @SerializedName("data") val data: List<Group>
) {
    data class Group(

        @SerializedName("groupid") val groupid: String,
        @SerializedName("group_name") val group_name: String,
        @SerializedName("accountid") val accountid: String,
        @SerializedName("icon_url") val icon_url: String,
        @SerializedName("units") val units: List<String>
    )
}
