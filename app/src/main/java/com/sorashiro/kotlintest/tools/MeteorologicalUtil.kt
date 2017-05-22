package com.sorashiro.kotlintest.tools

import java.text.DecimalFormat

object MeteorologicalUtil {

    fun getWindDegreeStr(degree: Double): String{
        val ori = degree.toInt() / 45
        val deg = degree % 45
        var result = ""
        when(ori) {
            0 -> {
                if (deg == 0.0) {
                    result += "正北"
                } else {
                    result += "北偏东$deg°"
                }
            }
            1 -> {
                if (deg == 0.0) {
                    result += "东北"
                } else {
                    result += "东偏北$deg°"
                }
            }
            2 -> {
                if (deg == 0.0) {
                    result += "正东"
                } else {
                    result += "东偏南$deg°"
                }
            }
            3 -> {
                if (deg == 0.0) {
                    result += "东南"
                } else {
                    result += "南偏东$deg°"
                }
            }
            4 -> {
                if (deg == 0.0) {
                    result += "正南"
                } else {
                    result += "南偏西$deg°"
                }
            }
            5 -> {
                if (deg == 0.0) {
                    result += "西南"
                } else {
                    result += "西偏南$deg°"
                }
            }
            6 -> {
                if (deg == 0.0) {
                    result += "正西"
                } else {
                    result += "西偏北$deg°"
                }
            }
            7 -> {
                if (deg == 0.0) {
                    result += "西北"
                } else {
                    result += "北偏西$deg°"
                }
            }
        }
        return result
    }

    fun tempKtoCStr(temp: Double): String{
        val format = DecimalFormat("##0.00")
        return format.format(temp-273.16)
    }

}
