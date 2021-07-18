package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeleteAccountGroupResponse(
        @SerializedName("type")
        @Expose var type: String,
        @SerializedName("value")
        @Expose var value: Value,
        @SerializedName("text")
        @Expose var text: String
){


        data class Value (

                @SerializedName("command") val command : String,
                @SerializedName("rowCount") val rowCount : Int,
                @SerializedName("oid") val oid : String,
                @SerializedName("rows") val rows : List<String>,
                @SerializedName("fields") val fields : List<String>,
                @SerializedName("_parsers") val _parsers : List<String>,
                @SerializedName("RowCtor") val rowCtor : String,
                @SerializedName("rowAsArray") val rowAsArray : Boolean
        )
}
