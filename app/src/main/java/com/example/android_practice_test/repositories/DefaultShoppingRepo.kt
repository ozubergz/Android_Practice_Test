package com.example.android_practice_test.repositories

import androidx.lifecycle.LiveData
import com.example.android_practice_test.data.local.ShoppingDao
import com.example.android_practice_test.data.local.ShoppingItem
import com.example.android_practice_test.data.remote.ImageService
import com.example.android_practice_test.data.remote.model.ImageResponse
import com.example.android_practice_test.other.Resource
import java.lang.Exception
import javax.inject.Inject

class DefaultShoppingRepo @Inject constructor(
    private val dao: ShoppingDao,
    private val api: ImageService
) : ShoppingRepo {

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        return dao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        return dao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return dao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return dao.observeTotalPrice()
    }

    override suspend fun fetchImage(searchQuery: String): Resource<ImageResponse> {
        return try {
            val response = api.fetchImage(searchQuery)

            return if(response.isSuccessful) {
                Resource.success(response.body())
            } else {
                Resource.error("Error occurred", null)
            }

        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Check you internet connection.", null)
        }
    }

}