package com.sorashiro.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sorashiro.kotlintest.tools.AppSaveDataSPUtil

import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        AppSaveDataSPUtil.init(this)

        initView()

    }

    fun initView(){

        textTitle.text = intent.getStringExtra("name")

    }

}
