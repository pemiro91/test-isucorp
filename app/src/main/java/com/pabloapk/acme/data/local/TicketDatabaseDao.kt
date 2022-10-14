package com.pabloapk.acme.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pabloapk.acme.data.model.TicketEntity

@Dao
interface TicketDatabaseDao {


    @Query("SELECT * FROM ticket_table ORDER BY ticketId DESC")
    fun getAllTicket(): LiveData<MutableList<TicketEntity>>

//    @Query("SELECT * FROM ticket_table WHERE number LIKE :number")
//    suspend fun getNumberTicket(number: String): TicketEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tickets: List<TicketEntity>)

    @Delete
    fun delete(ticket: TicketEntity)

    @Delete
    fun deleteAll(ticket: List<TicketEntity>?)

    @Update
    fun update(ticket: TicketEntity)
}