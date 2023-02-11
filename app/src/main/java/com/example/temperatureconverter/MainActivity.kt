package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.example.temperatureconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var temperatureConverter: TempConverterModel

    private var celsius:Float = 0F
    private var fahrenheit:Float = 32F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        temperatureConverter = TempConverterModel()

        binding.celsiusSeekBar.max = 100
        binding.fahrenheitSeekBar?.max ?: 212

        binding.celsiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Float, fromUser: Boolean, view: View) {
                if (fromUser) {
                    celsius = progress
                    fahrenheit = temperatureConverter.celsiusToFahrenheit(progress)
                    binding.fahrenheitSeekBar?.progress ?: fahrenheit
                    Snackbar.make(view,
                        R.string.warmer,
                        Snackbar.LENGTH_SHORT).show()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.fahrenheitSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Float, fromUser: Boolean) {
                if (fromUser) {
                    if (progress < 32) {
                        binding.fahrenheitSeekBar.progress = 32
                        Toast.makeText(
                            this@MainActivity,
                            "The Fahrenheit SeekBar cannot remain below 32° F",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        fahrenheit = progress.toFloat()
                        celsius = temperatureConverter.fahrenheitToCelsius(progress)
                        binding.celsiusSeekBar.progress = celsius
                        showSnackbar(celsius)
                    }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}