package id.ac.amikom.github.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.amikom.github.api.RetrofitClient
import id.ac.amikom.github.data.model.User
import id.ac.amikom.github.data.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val ListUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String){
        RetrofitClient.apiInstance
            .getSearchUsers(query)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        ListUsers.run { postValue(response.body()?.items) }
                    }
                }
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                   Log.d("Faliure", t.message)
                }

            })
    }
    fun getSearchUsers(): LiveData<ArrayList<User>>{
        return ListUsers
    }
}