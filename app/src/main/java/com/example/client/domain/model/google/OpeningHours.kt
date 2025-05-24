package com.example.client.domain.model.google
import com.google.gson.annotations.SerializedName

data class OpeningHours(
    @SerializedName("open_now")
    val openNow: Boolean?,
    @SerializedName("weekday_text")
    val weekdayText: List<String>?
)