package com.example.myfirstproject

enum class UnitOfMeasure(val abbreviation: String, val toMeters: Double) {
    Centimeters("Centimeters", 0.01),
    Meters("Meters", 1.0),
    Inches("Inches", 0.0254),
    Feet("Feet", 0.3048),
    Millimeters("Millimeters", 0.001),
    Kilometers("Kilometers", 1000.0),
    Yards("Yards", 0.9144),
    Miles("Miles", 1609.34)
}
