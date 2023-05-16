package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            openDialog()
        }

    }

    private fun openDialog() {
        val dialog = MaterialDialog.Builder(this).customView(R.layout.custom_dialog, false).build()
        dialog.window!!.attributes.windowAnimations = R.style.CustomDialogAnimation
        dialog.show()
    }
}