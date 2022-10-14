package com.pabloapk.acme

import android.app.Application
import com.pabloapk.acme.data.local.IsucorpDatabase
import com.pabloapk.acme.data.repository.IsucorpRepository

class IsucorpApplication : Application()  {
    private val database by lazy { IsucorpDatabase.getInstance(this) }
    val repository by lazy { IsucorpRepository(database.userDatabaseDao, database.ticketDatabaseDao) }
}