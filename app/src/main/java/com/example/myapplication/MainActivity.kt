package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.parentLayout.setOnClickListener {
//            binding.tvTextAnimate.animate()
//                .translationYBy(-150F)
//                .setInterpolator(AccelerateDecelerateInterpolator())
//                .setStartDelay(3000L)
//                .setDuration(100L)
//                .withEndAction {
//                    binding.tvTextAnimate.isVisible = false
//                }
//                .start()
//        }

//        binding.parentLayout.setOnClickListener {
//            animateUp()
////            animateDown()
//        }
        animateUp()
        animateDown()

//        val animateUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
//        val animateDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
//
//        binding.parentLayout.setOnClickListener {
//            binding.tvTextAnimate.startAnimation(animateUp)
//        }
    }

    fun animateUp() {
        binding.tvTextAnimate.animate()
            .translationYBy(-50F)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setStartDelay(3000L)
            .setDuration(300L)
            .withStartAction {
//                binding.tvTextAnimateDown.isVisible = true
            }
            .withEndAction {
//                binding.tvTextAnimate.isVisible = false
                animateDown()
            }
            .start()

//        val animateUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
//
////        binding.tvTextAnimate.startAnimation(animateUp)
//        binding.tvTextAnimateDown.startAnimation(animateUp)

//        binding.tvTextAnimateDown.animate()
//            .translationYBy(-50F)
//            .setInterpolator(AccelerateDecelerateInterpolator())
//            .setStartDelay(3000L)
//            .setDuration(500L)
//            .withEndAction {
//            }
//            .start()
//        binding.tvTextAnimateDown.animate()
//            .translationYBy(50F)
//            .setInterpolator(AccelerateDecelerateInterpolator())
//            .setStartDelay(3000L)
//            .setDuration(500L)
//            .withEndAction { binding.tvTextAnimateDown.isVisible = true }
//            .start()
    }

    fun animateDown() {
//        binding.tvTextAnimate.isVisible = true
        binding.tvTextAnimate.animate()
            .translationYBy(50F)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setStartDelay(3000L)
            .setDuration(300L)
            .withStartAction {
//                binding.tvTextAnimate.isVisible = true
            }
            .withEndAction {
//                binding.tvTextAnimateDown.isVisible = false
//                binding.tvTextAnimate.isVisible = true
                animateUp()
            }
            .start()

//        val animateUp = AnimationUtils.loadAnimation(this, R.anim.slide_down)
//
//        binding.tvTextAnimateDown.startAnimation(animateUp)
//        binding.tvTextAnimate.animate()
//            .translationYBy(50F)
//            .setInterpolator(AccelerateDecelerateInterpolator())
//            .setStartDelay(3000L)
//            .withEndAction {
//                binding.tvTextAnimate.isVisible = false
//                animateUp()
//            }
//            .setDuration(500L)
//            .start()

//        binding.tvTextAnimateDown.animate()
//            .translationY(50f)
//            .setInterpolator(AccelerateDecelerateInterpolator())
//            .setStartDelay(3000L)
//            .setDuration(500L)
//            .withStartAction {binding.tvTextAnimate.isVisible = true }
//            .withEndAction {
//                binding.tvTextAnimateDown.isVisible = false
//                animateUp()
//            }
//            .start()
    }
}