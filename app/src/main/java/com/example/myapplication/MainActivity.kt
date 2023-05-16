package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var isUp = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.parentLayout.setOnClickListener {
            isUp = !isUp
            binding.tvTextAnimateDown.isVisible = true
            if (isUp)
                animateUp()
            else
                animateDown()
        }

    }

    fun animateUp() {
        binding.tvTextAnimate.animate()
            .alpha(0.2f)
            .translationY((-500).dp())
            .start()
        binding.imgView.animate()
            .alpha(0F)
            .translationX(-50.dp())
            .start()

        binding.tvTextAnimateDown.y = 500.dp()
        binding.tvTextAnimateDown.animate()
            .alpha(1f)
            .translationY(0F)
            .withEndAction {
                Handler(Looper.getMainLooper()).postDelayed({animateDown()},3000)
            }
            .start()
    }

    fun animateDown() {
        binding.tvTextAnimate.animate()
            .alpha(1F)
            .translationY(0.dp())
            .start()
        binding.imgView.animate()
            .alpha(1F)
            .translationX(0.dp())
            .start()
        binding.tvTextAnimateDown.y = 0.dp()
        binding.tvTextAnimateDown.animate()
            .alpha(0.2F)
            .translationY(-500F)
            .withEndAction {
            Handler(Looper.getMainLooper()).postDelayed({animateUp()},3000)
            }
            .start()
    }

    fun Int.dp(): Float {
        val destiny = resources.displayMetrics.density
        return this / destiny
    }
}