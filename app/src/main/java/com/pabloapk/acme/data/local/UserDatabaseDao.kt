package com.pabloapk.acme.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pabloapk.acme.data.model.UserEntity

@Dao
interface UserDatabaseDao {

    @Query("SELECT * FROM users_table WHERE user_name LIKE :arg0 AND password_text LIKE :arg1")
    fun readLoginData(arg0: String, arg1: String):UserEntity

    @Query("SELECT * FROM users_table ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM users_table WHERE userId = :uid")
    fun getByUid(uid: Int): LiveData<UserEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<UserEntity>)

    @Delete
    fun delete(user: UserEntity)

    @Delete
    fun deleteAll(user: List<UserEntity>?)

    @Update
    fun update(user: UserEntity)


}