package com.pabloapk.acme.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticket_table")
data class TicketEntity(
    @PrimaryKey(autoGenerate = true)
    var ticketId: Int = 0,
    var service: String,
    var street: String,
    var city: String,
    var code: String,
    var hour: String,
    var date: String,
    var number: String,
    var scheduled: String,
    var customerInfo: String,
    var phone: String,
    var distance: String,
    var miles: String,
    var dispatch_note1: String,
    var dispatch_note2: String,
    var dept_class: String,
    var service_type: String,
    var url_google: String
): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }
}
