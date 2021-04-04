package com.example.android_practice_test.di

import android.content.Context
import androidx.room.Room
import com.example.android_practice_test.data.local.ShoppingDao
import com.example.android_practice_test.data.local.ShoppingItemDB
import com.example.android_practice_test.data.remote.ImageService
import com.example.android_practice_test.other.Constants.BASE_URL
import com.example.android_practice_test.other.Constants.DATABASE_NAME
import com.example.android_practice_test.repositories.DefaultShoppingRepo
import com.example.android_practice_test.repositories.ShoppingRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val client = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }.let {
            OkHttpClient.Builder().addInterceptor(it).build()
        }

    @Singleton
    @Provides
    fun provideShoppingItemDB(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ShoppingItemDB::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideShoppingDao(database: ShoppingItemDB) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayAPI(): ImageService = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()
        .create(ImageService::class.java)

    @Singleton
    @Provides
    fun provideDefaultShoppingRepo(
        dao: ShoppingDao,
        api: ImageService
    ) = DefaultShoppingRepo(dao, api) as ShoppingRepo

}