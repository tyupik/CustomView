package ru.netology.customview

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val view = findViewById<StatsView>(R.id.statsView)

        view.data = listOf(
            500F, 500F, 500F, 500F
//            123F, 321F, 500F
//            0.25F, 0.25F, 0.25F, 0.25F
        )






//        val label = findViewById<TextView>(R.id.label)
//
//        val viewAnim = AnimationUtils.loadAnimation(
//            this, R.anim.view_animation
//        ).apply {
//            setAnimationListener(object: Animation.AnimationListener {
//                override fun onAnimationStart(p0: Animation?) {
//                    label.text = "started"
//                }
//
//                override fun onAnimationEnd(p0: Animation?) {
//                    label.text = "ended"
//                }
//
//                override fun onAnimationRepeat(p0: Animation?) {
//                    label.text = "repeat"
//                }
//            })
//        }
//
//        view.startAnimation(viewAnim)


//        ObjectAnimator.ofFloat(view, "alpha", 0.25F, 1F). apply {
//            startDelay = 500
//            duration = 3000
//            interpolator = BounceInterpolator()
//        }.start()

//        ObjectAnimator.ofFloat(view, View.ALPHA, 0.25F, 1F).apply {
//            startDelay = 500
//            duration = 3000
//            interpolator = BounceInterpolator()
//        }.start()

//        val rotation = PropertyValuesHolder.ofFloat(View.ROTATION, 0F, 360F)
//        val alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0F, 1F)
//        ObjectAnimator.ofPropertyValuesHolder(view, rotation, alpha)
//            .apply {
//                startDelay = 500
//                duration = 500
//                interpolator = LinearInterpolator()
//            }.start()

//        view.animate()
//            .rotation(360F)
//            .scaleX(1.2F)
//            .scaleY(1.2F)
//            .setInterpolator(LinearInterpolator())
//            .setStartDelay(500)
//            .setDuration(500)
//            .start()


    }
}