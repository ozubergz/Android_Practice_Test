package com.example.android_practice_test.repositories

import androidx.lifecycle.LiveData
import com.example.android_practice_test.data.local.ShoppingItem
import com.example.android_practice_test.data.remote.model.ImageResponse
import com.example.android_practice_test.other.Resource


interface ShoppingRepo {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems() : LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun fetchImage(searchQuery: String) : Resource<ImageResponse>
}