package com.pabloapk.acme.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pabloapk.acme.data.model.TicketEntity
import com.pabloapk.acme.data.model.UserEntity

@Database(entities = [UserEntity::class, TicketEntity::class], version = 1, exportSchema = false)
abstract class IsucorpDatabase  : RoomDatabase()  {

    abstract val userDatabaseDao: UserDatabaseDao
    abstract val ticketDatabaseDao: TicketDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: IsucorpDatabase? = null

        fun getInstance(context: Context): IsucorpDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        IsucorpDatabase::class.java,"test_database")
                        .fallbackToDestructiveMigration().allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}