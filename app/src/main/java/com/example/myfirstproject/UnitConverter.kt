package com.example.myfirstproject
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstproject.ui.theme.MyFirstProjectTheme
import kotlin.math.roundToInt

// TODO -> TRY TO CREATE A HISTORIC CONVERTED VALUES

//creating my own @Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }

    var inputUnit by remember { mutableStateOf("select") }
    var outputUnit by remember { mutableStateOf("select") }

    //for the dropdown menu
    var inputExpanded by remember { mutableStateOf(false) }
    var outputExpanded by remember { mutableStateOf(false) }

    //for the result print
    var outputUnitResult by remember { mutableStateOf("") }

    val conversionFactor = remember { mutableDoubleStateOf(1.0) }
    val outputConversionFactor = remember { mutableDoubleStateOf(1.0) }


    fun convertUnits() {

        if(inputUnit == "select" && outputUnit == "select") {
            outputValue = ""
        } else if(inputUnit == "select" || outputUnit == "select") {
            outputValue = 0.0.toString()
        }else{

            val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0

            val result = (inputValueDouble * conversionFactor.doubleValue * 100.0 / outputConversionFactor.doubleValue).roundToInt() / 100.0
            outputValue = result.toString()
        }
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        // Here all the UI elements will be stack ed below each other
        Text("Unit Converter", style = unitConverterTextStyle)


        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Black,
                cursorColor = Color.Black,
                focusedLabelColor = Color.Blue,
                unfocusedLabelColor = Color.Black,),

            //NOT ALLOW CHANGE OF SPACE
            singleLine = true,
            value = inputValue,
            onValueChange =  { inputValue = it },
            label = { Text(text = "Enter the value", fontSize = 16.sp)
                convertUnits()}

        )
        Spacer(modifier = Modifier.height(16.dp))


        Row {
            // Here all the UI elements will be stacked next each other
            Box {
                //Input Button
                Button(onClick = {inputExpanded = true  }) {
                    Text((inputUnit))
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = inputExpanded, onDismissRequest = { inputExpanded = false}) {
                    //Centimeters
                    DropdownMenuItem(
                        text = { Text(UnitOfMeasure.Centimeters.name) },
                        onClick = {
                            inputUnit = UnitOfMeasure.Centimeters.abbreviation
                            inputExpanded = false
                            conversionFactor.doubleValue = UnitOfMeasure.Centimeters.toMeters})

                    //Meters
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Meters.name) },
                        onClick = {
                            inputUnit = UnitOfMeasure.Meters.abbreviation
                            inputExpanded = false
                            conversionFactor.doubleValue = UnitOfMeasure.Meters.toMeters})

                    //Inches
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Inches.name) },
                        onClick = {
                            inputUnit = UnitOfMeasure.Inches.abbreviation
                            inputExpanded = false
                            conversionFactor.doubleValue = UnitOfMeasure.Inches.toMeters})

                    //Feet
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Feet.name) }, onClick = {
                        inputUnit = UnitOfMeasure.Feet.abbreviation
                        inputExpanded = false
                        conversionFactor.doubleValue = UnitOfMeasure.Feet.toMeters})

                    //Millimetres
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Millimeters.name) }, onClick = {
                        inputUnit = UnitOfMeasure.Millimeters.abbreviation
                        inputExpanded = false
                        conversionFactor.doubleValue = UnitOfMeasure.Millimeters.toMeters})
                    //Kilometres
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Kilometers.name) }, onClick = {
                        inputUnit = UnitOfMeasure.Kilometers.abbreviation
                        inputExpanded = false
                        conversionFactor.doubleValue = UnitOfMeasure.Kilometers.toMeters
                    })

                    //Yards
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Yards.name) }, onClick = {
                        inputUnit = UnitOfMeasure.Yards.abbreviation
                        inputExpanded = false
                        conversionFactor.doubleValue = UnitOfMeasure.Yards.toMeters
                    })

                    //Miles
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Miles.name) }, onClick = {
                        inputUnit = UnitOfMeasure.Miles.abbreviation
                        inputExpanded = false
                        conversionFactor.doubleValue = UnitOfMeasure.Miles.toMeters
                    })
                }
            }

            //Space between the two select boxes
            Spacer(modifier = Modifier.width(16.dp))

            Box {
                //Output Button
                Button(onClick = {outputExpanded = true  }) {
                    Text((outputUnit))
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = outputExpanded, onDismissRequest = { outputExpanded = false}) {
                    //Centimeters
                    DropdownMenuItem(
                        text = { Text(UnitOfMeasure.Centimeters.name) },
                        onClick = {
                            outputUnit = UnitOfMeasure.Centimeters.abbreviation
                            outputUnitResult = outputUnit
                            outputExpanded = false
                            outputConversionFactor.doubleValue = UnitOfMeasure.Centimeters.toMeters
                            convertUnits()})

                    //Meters
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Meters.name) },
                        onClick = {
                            outputUnit = UnitOfMeasure.Meters.abbreviation
                            outputUnitResult = outputUnit
                            outputExpanded = false
                            outputConversionFactor.doubleValue = UnitOfMeasure.Meters.toMeters
                            convertUnits()})

                    //Inches
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Inches.name) },
                        onClick = {
                            outputUnit = UnitOfMeasure.Inches.abbreviation
                            outputUnitResult = outputUnit
                            outputExpanded = false
                            outputConversionFactor.doubleValue = UnitOfMeasure.Inches.toMeters
                            convertUnits()})

                    //Feet
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Feet.name) }, onClick = {
                        outputUnit = UnitOfMeasure.Feet.abbreviation
                        outputUnitResult = outputUnit
                        outputExpanded = false
                        outputConversionFactor.doubleValue = UnitOfMeasure.Feet.toMeters
                        convertUnits()})

                    //Millimetres
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Millimeters.name) }, onClick = {
                        outputUnit = UnitOfMeasure.Millimeters.abbreviation
                        outputUnitResult = outputUnit
                        outputExpanded = false
                        outputConversionFactor.doubleValue = UnitOfMeasure.Millimeters.toMeters
                        convertUnits()})

                    //Yards
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Yards.name) }, onClick = {
                        outputUnit = UnitOfMeasure.Yards.abbreviation
                        outputUnitResult = outputUnit
                        outputExpanded = false
                        outputConversionFactor.doubleValue = UnitOfMeasure.Yards.toMeters
                        convertUnits()})

                    //Kilometres
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Kilometers.name) }, onClick = {
                        outputUnit = UnitOfMeasure.Kilometers.abbreviation
                        outputUnitResult = outputUnit
                        outputExpanded = false
                        outputConversionFactor.doubleValue = UnitOfMeasure.Kilometers.toMeters
                        convertUnits()})

                    //Miles
                    DropdownMenuItem(text = { Text(UnitOfMeasure.Miles.name) }, onClick = {
                        outputUnit = UnitOfMeasure.Miles.abbreviation
                        outputUnitResult = outputUnit
                        outputExpanded = false
                        outputConversionFactor.doubleValue = UnitOfMeasure.Miles.toMeters
                        convertUnits()})

                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Mostra o resultado da conversãosim m
        Text("Converted Value: $outputValue $outputUnitResult",
            style = resultTextStyle)
    }


}



@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    MyFirstProjectTheme {
        UnitConverter()
    }
}