package com.example.superheroes.activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroes.*
import com.example.superheroes.SuperheroAdapter.HeroListener
import com.example.superheroes.interfaces.ApiService
import com.example.superheroes.databinding.ActivityMainBinding
import com.example.superheroes.interfaces.TaskDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Principal : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SuperheroAdapter
    private val superheroList: MutableList<Superhero> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        initRecyclerView()


        bt_buscar.setOnClickListener{
            var superheroName: String = et_busqueda.text.toString()
            searchByName(superheroName)
        }

    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
                .baseUrl("https://www.superheroapi.com/api.php/892894741254257/search/")
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
        return okHttpClientBuilder.build()
    }

    private fun searchByName(query: String){
        if(isNetworkAvailable(this)){
            CoroutineScope(Dispatchers.IO).launch {
                var url = "https://www.superheroapi.com/api.php/892894741254257/search/$query"
                val call = getRetrofit().create(ApiService::class.java).getSuperherosbyId(url)
                val superheros : Superheros? = call.body()
                runOnUiThread{
                    if (call.isSuccessful) {

                        val data: Superheros? = superheros

                        superheroList.clear()
                        if(data!=null){
                            var listHeros = data.results
                            if (listHeros != null) {
                                superheroList.addAll(listHeros)
                            }
                            superheroList.map { it.nid = it.id!!.toLong() }
                            almacenarDatos(superheroList)
                                rv_lista.adapter!!.notifyDataSetChanged()
                        }
                    }
                    else {
                        Toast.makeText(this@Principal, "Error al conectar a base de datos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        else{
            (application as MySuperheroApp).getDataBase().taskDao().getSuperhero(query)
        }

    }

    private fun almacenarDatos(superheroList: MutableList<Superhero>) {
        CoroutineScope(Dispatchers.IO).launch {
            for (hero in superheroList) {
                (application as MySuperheroApp).getDataBase().taskDao().addSuperhero(hero)
            }
        }
    }

    fun isNetworkAvailable(context: Context):Boolean =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo.isConnectedOrConnecting

    private fun initRecyclerView(){
        adapter = SuperheroAdapter(superheroList, object : HeroListener {
            override fun listen(hero: Superhero) {
                itemSelected(hero)
            }
        })
        rv_lista.layoutManager = LinearLayoutManager(this)
        rv_lista.adapter = adapter
    }

    private fun itemSelected(superhero: Superhero){
        val intent = Intent(this, Details::class.java)
        val extra = Bundle()
        extra.putSerializable("Superhero", superhero)
        intent.putExtras(extra)
        startActivity(intent)
    }

}