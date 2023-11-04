package com.cmsbando.erp.api

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {
  @POST("api")
  fun login(@Body loginRequest: ErpInterface.LoginInfo): Call<JsonObject>
  @POST("api")
  suspend fun fetchData(): JsonObject
}

class ApiHandler {
  val retrofit = Retrofit.Builder().baseUrl("http://cms.ddns.net:3007")
    .addConverterFactory(GsonConverterFactory.create()).build()
  val apiService = retrofit.create(ApiService::class.java)

  fun loginExcute(username: String, password: String, globalVar: GlobalVariable) {
    val loginRequest = ErpInterface.LoginInfo("login", username, password)
    val call = apiService.login(loginRequest)
    call.enqueue(object : Callback<JsonObject> {
      @RequiresApi(Build.VERSION_CODES.O)
      override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
        if (response.isSuccessful) {
          val employee = response.body()
          if (employee != null) {
            val tk_status: String = employee.get("tk_status").asString
            Log.d("xxx", employee.toString())
            if (tk_status != "ng") {
              val empl_info = employee.get("userData").asString
              val gson = Gson()
              val employeeType = object : TypeToken<List<ErpInterface.Employee>>() {}.type
              val persons: List<ErpInterface.Employee> = gson.fromJson(empl_info, employeeType)
              Log.d("xxx", "Trang thai: ${persons.get(0).EMPL_NO}")
              globalVar.globalDialogState = true
            } else {
              Log.d("xxx", "Login thất bại")
            }
          } else {
            Log.d("xxx", "Có lỗi")

          }
          // Xử lý thông tin nhân viên sau khi đăng nhập
        } else {
          // Xử lý lỗi đăng nhập ở đây
          Log.d("xxx", "Có lỗi")

        }
      }

      override fun onFailure(call: Call<JsonObject>, t: Throwable) {
        // Xử lý lỗi kết nối ở đây

        Log.d("xxx", "Có lỗi 2 ${t.message}")

      }
    })


  }


}