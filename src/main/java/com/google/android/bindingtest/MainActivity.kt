package com.google.android.bindingtest

import com.google.android.bindingtest.R
import android.widget.Button
import android.widget.TextView
import android.app.Activity
import dagger.Component
import android.os.Bundle
import com.google.android.bindingtest.retrofit_gson_test.RequestApi
import com.google.android.bindingtest.retrofit_gson_test.ExchangeResponse
import com.google.android.bindingtest.no_moshi_test.GaeExplorationContainer
import com.google.android.bindingtest.no_moshi_test.ExplorationService
import com.google.android.bindingtest.no_moshi_test.NetworkSettings
import com.google.android.bindingtest.no_moshi_test.NetworkInterceptor
import com.google.android.bindingtest.no_moshi_test.NetworkModule
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.net.Credentials
import android.util.Log
import java.io.IOException
import java.util.logging.Level

class MainActivity : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    var networkInterceptor: NetworkInterceptor = NetworkInterceptor()
    var okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(networkInterceptor).build()
    val retrofit = Retrofit.Builder().baseUrl("https://oppia.org/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    val posts = retrofit.create(ExplorationService::class.java)
    val response = posts.getExplorationById()

    /*
    val component = DaggerSimpleComponent.builder().build()
    val testTextView: TextView = findViewById(R.id.test_text_view)
    testTextView.text = component.getStringProvider().getString()
    val crashButton: Button = findViewById(R.id.test_button)
    crashButton.setOnClickListener {
      throw RuntimeException("Test Crash") // Force a crash
    }
    */
    /*
    response_rates.enqueue(object : Callback<ExchangeResponse>{
      override fun onFailure(call: Call<ExchangeResponse>, t: Throwable) {
      }

      override fun onResponse(call: Call<ExchangeResponse>, response: Response<ExchangeResponse>) {
        val mResponse = response_rates.body()
        val usd_text: TextView = findViewById(R.id.usd_text)
        val rub_text: TextView = findViewById(R.id.rub_text)
        usd_text.text = "USD: ${mResponse?.rates!!.USD.toString()}"
        rub_text.text = "RUB: ${mResponse?.rates!!.RUB.toString()}"
      }

    })*/

    response.enqueue(object : Callback<GaeExplorationContainer>{

      override fun onFailure(call: Call<GaeExplorationContainer>, t: Throwable) {
        val record_playthrough_probability: TextView = findViewById(R.id.record_playthrough_probability)
        record_playthrough_probability.text = "No Response Received"
      }

      override fun onResponse(call: Call<GaeExplorationContainer>, response: Response<GaeExplorationContainer>) {
        val mResponse = response.body()

        val record_playthrough_probability: TextView = findViewById(R.id.record_playthrough_probability)
        val exploration_id: TextView = findViewById(R.id.exploration_id)
        val state_classifier_mapping: TextView = findViewById(R.id.state_classifier_mapping)
        val user_email: TextView = findViewById(R.id.user_email)
        val version: TextView = findViewById(R.id.version)
        val correctness_feedback_enabled: TextView = findViewById(R.id.correctness_feedback_enabled)
        val username: TextView = findViewById(R.id.username)
        val is_logged_in: TextView = findViewById(R.id.is_logged_in)
        val exploration: TextView = findViewById(R.id.exploration)
        val session_id: TextView = findViewById(R.id.session_id)

        record_playthrough_probability.text = "record: ${mResponse?.record_playthrough_probability.toString()}" //expected value: 0.2
        exploration_id.text = "expl id: ${mResponse?.exploration_id.toString()}" //expected value: umPkwp0L1M0-
        state_classifier_mapping.text = "state mapping: ${mResponse?.state_classifier_mapping.toString()}"
        user_email.text = "email: ${mResponse?.user_email.toString()}"
        version.text = "version: ${mResponse?.version.toString()}"
        correctness_feedback_enabled.text = "feedback: ${mResponse?.correctness_feedback_enabled.toString()}"
        username.text = "username: ${mResponse?.username.toString()}"
        is_logged_in.text = "logged in: ${mResponse?.is_logged_in.toString()}"
        exploration.text = "exploration: ${mResponse?.exploration.toString()}"
        session_id.text = "session: ${mResponse?.session_id.toString()}"

        /*
        val id: TextView = findViewById(R.id.id)
        val answer_groups: TextView = findViewById(R.id.answer_groups)
        val solution: TextView = findViewById(R.id.solution)
        val confirmed_unclassified_answers: TextView = findViewById(R.id.confirmed_unclassified_answers)
        val hints: TextView = findViewById(R.id.hints)
        val default_outcome: TextView = findViewById(R.id.default_outcome)
        val customization_args: TextView = findViewById(R.id.customization_args)


        id.text = "id: ${mResponse?.id.toString()}"
        answer_groups.text = "answer groups: ${mResponse?.answer_groups!!.tagged_skill_misconception_id.toString()}"
        solution.text = "solution: ${mResponse?.solution!!.interaction_id.toString()}"
        confirmed_unclassified_answers.text = "confirmed: ${mResponse?.confirmed_unclassified_answers!!.toString()}"
        hints.text = "hints: ${mResponse?.hints!!.toString()}"
        default_outcome.text = "outcome: ${mResponse?.default_outcome!!.toString()}"
        customization_args.text = "custom: ${mResponse?.customization_args!!.toString()}"
         */
      }

    })



  }
}
