package com.example.m14_retrofit

import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m14_retrofit.databinding.ActivityMainBinding
import com.example.m14_retrofit.retrofit.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.http.Path
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            val response = RetrofitServices.apiSearchUser.getUser()
            runOnUiThread {
                binding.textView.setText(response.body().toString())
            }
            val url = response.body()?.results?.get(0)?.picture?.large.toString()
            runOnUiThread {
                Glide.with(this@MainActivity).load(url).into(binding.imageUser)
            }

        }

        binding.buttonReset.setOnClickListener {
            lifecycleScope.launch {

                val response = RetrofitServices.apiSearchUser.getUser()
                runOnUiThread {
                    binding.textView.setText(response.body().toString())
                }
                val url = response.body()?.results?.get(0)?.picture?.large.toString()
                runOnUiThread {
                    Glide.with(this@MainActivity).load(url).into(binding.imageUser)
                }
            }
        }

    }

}
