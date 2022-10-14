package com.pabloapk.acme.data.repository

import androidx.lifecycle.LiveData
import com.pabloapk.acme.data.local.TicketDatabaseDao
import com.pabloapk.acme.data.local.UserDatabaseDao
import com.pabloapk.acme.data.model.TicketEntity
import com.pabloapk.acme.data.model.UserEntity

class IsucorpRepository(private val userDao: UserDatabaseDao, private val ticketDao: TicketDatabaseDao) {

    fun verifyLoginUser(username:String,password:String): UserEntity {
        return userDao.readLoginData(username, password)
    }

    // LiveData: all ticket
    fun getAllByTicketsData(): LiveData<MutableList<TicketEntity>> {
        return ticketDao.getAllTicket()
    }
}