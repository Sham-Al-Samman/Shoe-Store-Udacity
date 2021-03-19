package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.core.text.isDigitsOnly
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double = 0.0, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable
{
    constructor() : this("", 0.0, "", "")

    var sizeString : String
        get() = size.toString()
        set(value) { if(value.toDoubleOrNull() != null) size = value.toDouble() }
}