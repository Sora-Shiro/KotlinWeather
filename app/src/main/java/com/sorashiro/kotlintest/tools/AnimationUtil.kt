package com.sorashiro.kotlintest.tools

import android.view.View
import android.animation.ObjectAnimator


fun animTwinkle(view: View) {
    val animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.2f, 1f)
    animator.duration = 300
    animator.start()
}
