package ru.netology.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<StatsView>(R.id.statsView).data = listOf(
            500F, 500F, 500F, 500F
//            123F, 321F, 500F
//            0.25F, 0.25F, 0.25F, 0.25F
        )
    }
}