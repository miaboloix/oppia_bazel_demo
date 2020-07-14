package com.google.android.bindingtest

import com.google.android.bindingtest.R
import android.widget.Button
import android.widget.TextView
import android.app.Activity
import dagger.Component
/*package com.google.android.bindingtest

import android.widget.TextView
import android.widget.Button
import android.app.Activity
import android.os.Bundle


class MainActivity: Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main);

    val component = DaggerSimpleComponent.builder().build()
    val testTextView: TextView = findViewById(R.id.test_text_view)
    testTextView.text = component.getStringProvider().getString()
    val crashButton: Button = findViewById(R.id.test_button)
    //crashButton.setOnClickListener {
    //  Crashlytics.getInstance().crash() // Force a crash
    //}
    crashButton.setOnClickListener {
      throw RuntimeException("Test Crash") // Force a crash
    }
  }
}*/

//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.bindingtest.retrofit_gson_test.RequestApi
import com.google.android.bindingtest.retrofit_gson_test.ExchangeResponse
//import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : Activity() {

  private val retrofit = Retrofit.Builder().baseUrl("https://api.exchangeratesapi.io/")
          .addConverterFactory(GsonConverterFactory.create())
          .build()
  private val postsApi = retrofit.create(RequestApi::class.java)
  private val response = postsApi.getAllPosts()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val component = DaggerSimpleComponent.builder().build()
    val testTextView: TextView = findViewById(R.id.test_text_view)
    testTextView.text = component.getStringProvider().getString()
    val crashButton: Button = findViewById(R.id.test_button)
    crashButton.setOnClickListener {
      throw RuntimeException("Test Crash") // Force a crash
    }

    response.enqueue(object : Callback<ExchangeResponse>{
      override fun onFailure(call: Call<ExchangeResponse>, t: Throwable) {
      }

      override fun onResponse(call: Call<ExchangeResponse>, response: Response<ExchangeResponse>) {
        val mResponse = response.body()
        val usd_text: TextView = findViewById(R.id.usd_text)
        val rub_text: TextView = findViewById(R.id.rub_text)
        usd_text.text = "USD: ${mResponse?.rates!!.USD.toString()}"
        rub_text.text = "RUB: ${mResponse?.rates!!.RUB.toString()}"
      }

    })

  }
}
