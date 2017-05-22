package com.sorashiro.sorashirotools

import android.app.Activity

import java.util.Stack
import kotlin.properties.Delegates

/**
 * @author Sora
 *
 * @date 2017.5.1
 *
 *  Manage Activity by using Stack.
 *  用Stack来管理Activity。
 */

class ActivityManager private constructor() {

    companion object {

        val screenManager: ActivityManager by lazy {
            ActivityManager()
        }

        val activityStack: Stack<Activity> by Delegates.observable(Stack<Activity>()) {
            d, old, new ->
            //Nothing
        }

    }

//    companion object {
//
//        private var activityStack: Stack<Activity>? = null
//        private var instance: ActivityManager? = null
//
//        val screenManager: ActivityManager
//            get() {
//                if (instance == null) {
//                    instance = ActivityManager()
//                }
//                if (activityStack == null) {
//                    activityStack = Stack()
//                }
//                return instance
//            }
//
//    }

    fun popActivity() {
        var activity: Activity? = activityStack.lastElement()
        activity!!.finish()
        activity = null
    }

    fun popActivity(activity: Activity?) {
        var activityB = activity
        activityB!!.finish()
        activityStack.remove(activityB)
        activityB = null
    }

    fun currentActivity(): Activity? {
        if (activityStack.empty()) {
            return null
        }
        val activity = activityStack.lastElement()
        return activity
    }

    fun currentActivityCls(): Class<*>? {
        if (activityStack.empty()) {
            return null
        }
        val activity = activityStack.lastElement()
        return activity.javaClass
    }

    fun pushActivity(activity: Activity): Boolean {

        return activityStack.add(activity)

    }

    fun popAllActivityExceptOne(cls: Class<*>) {
        while (true) {
            val activity = currentActivity() ?: break
            if (activity.javaClass == cls) {
                break
            }
            popActivity(activity)
        }
    }

    fun popAll() {
        while (true) {
            val activity = currentActivity() ?: break
            popActivity(activity)
        }
    }

}