package com.example.temperatureconverter

class TempConverterModel {



    fun celsiusToFahrenheit(celsius: Float): Float {
        return (celsius * 9/5) + 32
    }

    fun fahrenheitToCelsius(fahrenheit: Int): Float {
        return (fahrenheit - 32) * 5/9
    }
}

/**
class TemperatureConverter {
    fun celsiusToFahrenheit(celsius: Int) = (celsius * 9 / 5) + 32
    fun fahrenheitToCelsius(fahrenheit: Int) = (fahrenheit - 32) * 5 / 9
}
        */