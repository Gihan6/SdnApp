package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetTagsListResponse(
        @SerializedName("result")
        @Expose var result: String,
        @SerializedName("data")
        @Expose var data: ArrayList<Data>
) {
    data class Data(
            @SerializedName("id")
            @Expose var id: String,
            @SerializedName("tag_name")
            @Expose var tag_name: String,
            @SerializedName("total_links")
            @Expose var total_links: String,
            @SerializedName("accountid")
            @Expose var accountid: String,
            @SerializedName("value_type")
            @Expose var value_type: String,
            @SerializedName("value")
            @Expose var value: String,
            @SerializedName("value_unit")
            @Expose var value_unit: String
    )
}