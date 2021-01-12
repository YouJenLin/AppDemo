package com.example.hw1.ui.login
import androidx.navigation.fragment.FragmentNavigator
import retrofit2.Call
import retrofit2.http.*

interface DestinationService {

    @PUT("users/{id}")
    fun updateDestination(
        @Path("id") id:String,
        @Field("timezone") timezone:Int
    ): Call<Destination>
}