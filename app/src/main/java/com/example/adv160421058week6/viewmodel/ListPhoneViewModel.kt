package com.example.adv160421058week6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160421058week6.model.Phone
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListPhoneViewModel(application: Application):AndroidViewModel(application) {
    val phoneLD = MutableLiveData<List<Phone>>()
    private var queue: RequestQueue? = null
    val TAG = "volleyTag"
    fun refresh() {
        Log.d("CEKMASUK", "masukvolley")
        queue = Volley.newRequestQueue(getApplication())

        val url = "http://10.0.2.2/phone/phone.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Phone>>() { }.type
                val result = Gson().fromJson<List<Phone>>(it, sType)
                phoneLD.value = result as ArrayList<Phone>?
                Log.d("showvolley", result.toString())
            },
            {
                Log.e("showvolley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}