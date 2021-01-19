package id.ac.amikom.github.api

import id.ac.amikom.github.data.model.DetailUserResponse
import id.ac.amikom.github.data.model.User
import id.ac.amikom.github.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface Api{
        @GET("search/users")
        @Headers("Authorization: token 1e486924cc7f3b37b68b5d0af3f5229babd446da")
        fun getSearchUsers(
            @Query("q") query: String
        ): Call<UserResponse>

        @GET("users/{username}")
        @Headers("Authorization: token 1e486924cc7f3b37b68b5d0af3f5229babd446da")
        fun getUserDetail(
            @Path("username") username: String
        ): Call<DetailUserResponse>

        @GET("users/{username}/followers")
        @Headers("Authorization: token 1e486924cc7f3b37b68b5d0af3f5229babd446da")
        fun getFollowers(
            @Path("username") username: String
        ): Call<ArrayList<User>>

        @GET("users/{username}/following")
        @Headers("Authorization: token 1e486924cc7f3b37b68b5d0af3f5229babd446da")
        fun getFollowing(
            @Path("username") username: String
        ): Call<ArrayList<User>>
    }
