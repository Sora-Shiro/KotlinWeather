package com.sorashiro.kotlintest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.sorashiro.kotlintest.adapter.WeatherListAdapter
import com.sorashiro.kotlintest.tools.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), WeatherListAdapter.OnItemClickListener{

    private var mList: RecyclerView by Delegates.notNull()
    private var mTextWeather: TextView? = null

//    private var mVersion: Any = 12
//    private var mVersionStr: String? = (mVersion as? Int).toString()
//    private var length: Int? = mVersionStr?.length

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        val tv = findViewById(R.id.text_title) as TextView
        tv.text = stringFromJNI()

        initView()

    }

    private val items = listOf(
            "Guangzhou",
            "London",
            "Shanghai",
            "Paris",
            "Beijing",
            "Jinan",
            "Chengdu"
    )

    fun initView() {

        mList = findViewById(R.id.list_weather) as RecyclerView
        mList.setHasFixedSize(true)
        mList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        mList.layoutManager = LinearLayoutManager(this)
        mList.adapter = WeatherListAdapter(this, items, this)

        //Anko
        mTextWeather = find(R.id.text_weather)

        toast("View initialed")

    }

    override fun onItemClick(view: View, position: Int, city: String) {
        AnimationUtil.animTwinkle(view)
        getWeatherData(city)
    }

    override fun onItemLongClick(view: View, position: Int, city: String) {
        AnimationUtil.animTwinkle(view)

        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("name", city)
        startActivity(intent)

    }

    fun getWeatherData(city: String) {
        //Anko
        doAsync {
            val url =
                    "http://api.openweathermap.org/data/2.5/weather?" +
                            "q=$city&" +
                            "APPID=$openWeatherMapApiKey"
            val cwJson = CurrentWeatherRequest(url).execute()

            val name = cwJson.name
            val temp = MeteorologicalUtil.tempKtoCStr(cwJson.main.temp) + "°C"
            val windDegree = MeteorologicalUtil.getWindDegreeStr(cwJson.wind.deg)
            val windSpeed = cwJson.wind.speed.toString() + "m/s"
            val humidity = cwJson.main.humidity.toString() + "%"

            val show = "城市 City：$name\n" +
                    "温度 Temp：$temp\n" +
                    "风向 WindOri：$windDegree\n" +
                    "风速 WindSpeed：$windSpeed\n" +
                    "湿度 Humidity：$humidity"

            uiThread {
                mTextWeather!!.text = show
            }
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
