package com.sorashiro.kotlintest.tools

import android.content.Context
import android.content.SharedPreferences
import java.lang.ref.WeakReference

/**
 * @author Sora
 *
 * @date 2016.11.7
 *
 *  A class to use SharedPreferences conveniently.
 *  MUST call init() BEFORE call other methods!
 *  一个方便使用SharedPreferences的类。
 *  调用其他方法前，请务必先调用init()方法！
 */

object AppSaveDataSPUtil {

    //Main Catalog
    //主目录
    private val DATA_CONFIG = "data_config"
    //Set Something
    //设置可存取的配置
    private val SOMETHING = "something"

    private var sContext: WeakReference<Context>? = null
    private var sSharedPreferences: SharedPreferences? = null
    private var sEditor: SharedPreferences.Editor? = null

    //Must call this function before change or get the data
    //修改或获得数据前必须先调用该函数
    fun init(context: Context) {
        if (sContext != null) {
            sContext = null
        }
        sContext = WeakReference(context)
        sSharedPreferences = context.getSharedPreferences(DATA_CONFIG, Context.MODE_PRIVATE)
        sEditor = sSharedPreferences!!.edit()
        sEditor!!.commit()
    }

    var something: Boolean
        get() = sSharedPreferences!!.getBoolean(SOMETHING, true)
        set(something) {
            sEditor!!.putBoolean(SOMETHING, something)
            sEditor!!.commit()
        }

}
