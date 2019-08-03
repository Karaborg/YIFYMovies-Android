package com.example.karaborg.yifymovies

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.example.karaborg.yifymovies.R.id.message
import com.example.karaborg.yifymovies.R.id.recycler_view
import com.example.karaborg.yifymovies.adapter.ListAdapter
import com.example.karaborg.yifymovies.data.MovieResponse
import com.example.karaborg.yifymovies.service.MovieService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_listitem.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCurrentData()

    }

    var baseUrl = "https://yts.am/api/v2/"

    private fun getCurrentData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MovieService::class.java)

        val call = service.getCurrentMovieData(50)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code() == 200) {
                    recycler_view.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = ListAdapter(response.body()!!, this@MainActivity, object :ListAdapter.OnItemClickListener{
                            override fun imageOnClick(pos: Int) {
                                Toast.makeText(this@MainActivity,"I Got, " + response.body()!!.data!!.movies!![pos]!!.title, Toast.LENGTH_SHORT).show()
                            }
                            override fun containerOnClick(pos: Int) {
                                val intent = Intent(this@MainActivity, MovieDetail::class.java)
                                intent.putExtra("movieResponse", response.body())
                                intent.putExtra("pos", pos)
                                startActivity(intent)
                            }
                        })
                    }
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })

    }

}
