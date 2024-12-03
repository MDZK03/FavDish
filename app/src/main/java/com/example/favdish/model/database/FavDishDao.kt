package com.example.favdish.model.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.favdish.model.entities.FavDish
import kotlinx.coroutines.flow.Flow

@Dao
interface FavDishDao {
    @Insert
    suspend fun insertDishDetails(favDish: FavDish)

    @Query("SELECT * FROM FAV_DISHES_TABLE ORDER BY ID")
    fun getDishesList(): Flow<List<FavDish>>

    @Update
    suspend fun updateDishDetails(favDish: FavDish)

    @Query("SELECT * FROM FAV_DISHES_TABLE WHERE favorite_dish = 1")
    fun getFavoriteList(): Flow<List<FavDish>>

    @Delete
    suspend fun deleteDish(favDish: FavDish)

    @Query("SELECT * FROM FAV_DISHES_TABLE WHERE type = :filterType")
    fun getFilteredList(filterType: String): Flow<List<FavDish>>
}