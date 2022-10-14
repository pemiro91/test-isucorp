package com.pabloapk.acme.data.local

import com.pabloapk.acme.data.model.TicketEntity
import com.pabloapk.acme.data.model.UserEntity

class ActionsInsertUtils {
    private val userItems: MutableList<UserEntity> = ArrayList()
    private val ticketItems: MutableList<TicketEntity> = ArrayList()

    fun getUserItems(): List<UserEntity> {
        //TODO:: Entity User
        userItems.add(UserEntity(1,"Pablo Ernesto", "Miró Martinez", "pemiro91", "123456789"))
        userItems.add(UserEntity(2,"Charo", "Villageliu", "charo", "123456789"))
        userItems.add(UserEntity(3,"Yeneisy", "Barroso Marquez", "charo", "123456789"))
        return userItems
    }

    fun getTicketItems(): List<TicketEntity> {
        //TODO:: Entity User
        ticketItems.add(TicketEntity(1,"Sink Repair", "8400 W 31st St",
            "Brookfield", "IL 60513", "11:35 AM", "10/10/2022", "35895",
            "Saturday, Dec 24, 2016 11:35 AM", "Jessica Green", "58 129938",
            "17 Minutes", "11.2", "fafgasfgafgasfgasfsfgasfadbgadgbadfbaefbaef",
            "fafgasfgafgasfgasfsfgasfadbgadgbadfbaefbaef", "Plumbing",
            "Call Back", "https://www.google.com/maps/place/Brookfield+Zoo/@41.8425945,-87.8101494,11.66z/data=!4m5!3m4!1s0x880e35e9b4e0ef2f:0x1b60a35fd648cf95!8m2!3d41.8326922!4d-87.8367964"))
        ticketItems.add(TicketEntity(2,"Water Heater Installation", "10240 Kingsway NW", "Edmonton", "AB T5H 3V9", "2:00 PM", "20/10/2022", "35896", "Sunday, Nov 26, 2017 12:55 AM", "Paul Crack", "58 653245", "24 Minutes", "21.2", "fafgasfgafgasfgasfsfgasfadbgadgbadfbaefbaef", "fafgasfgafgasfgasfsfgasfadbgadgbadfbaefbaef", "Plumbing", "Call Back", "https://www.google.com/maps/place/Royal+Alexandra+Hospital/@53.5412399,-113.5151193,12.56z/data=!3m1!5s0x53a023b219ccc46b:0x3ba4b9d5ff623c9c!4m12!1m6!3m5!1s0x880e35e9b4e0ef2f:0x1b60a35fd648cf95!2sBrookfield+Zoo!8m2!3d41.8326922!4d-87.8367964!3m4!1s0x53a023b2e9e5bdf3:0x6119380da89330f4!8m2!3d53.5573875!4d-113.4977721"))
        ticketItems.add(TicketEntity(3,"Drain Cleaning", "17404 99 Ave NW", "Edmonton", "AB T5T 5L5", "5:40 PM", "30/10/2022", "35897", "Monday, June 16, 2022 8:00 AM","Charles Durov", "58 663541", "50 Minutes", "31.2", "fafgasfgafgasfgasfsfgasfadbgadgbadfbaefbaef", "fafgasfgafgasfgasfsfgasfadbgadgbadfbaefbaef", "Plumbing", "Call Back", "https://www.google.com/maps/place/The+Home+Depot/@53.5479395,-113.6168264,13.56z/data=!4m5!3m4!1s0x53a020fb9b6b2403:0x3f849c1a52d18827!8m2!3d53.5367317!4d-113.6211339"))
        return ticketItems
    }
}