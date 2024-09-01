# MainActivity Documentation

## Overview

The `MainActivity` class is a core component of an Android application written in Kotlin. It extends `ComponentActivity` and serves as the entry point for the application. The primary function of this activity is to set up the user interface using Jetpack Compose and apply a theme to the UI.

# Unit Converter Application

## Overview

This code defines a Jetpack Compose UI for a unit converter application in Kotlin. It provides a user interface to convert values between different units of measurement. The application allows users to input a value, select input and output units from dropdown menus, and display the converted result.

## Key Components

1. **Imports:**
    - The necessary Jetpack Compose and Material3 libraries are imported to facilitate UI design and interaction.

2. **Composable Function:**
    - **`@Composable`**: This annotation is used to define composable functions which can be used to build UI elements in Jetpack Compose.

## Composable Function: `UnitConverter`

The main composable function is `UnitConverter`, which encapsulates the entire unit conversion UI and logic.

### State Management

- **`inputValue`**: Holds the value input by the user as a `String`.
- **`outputValue`**: Stores the result of the conversion as a `String`.
- **`inputUnit`**: Tracks the unit selected by the user for input.
- **`outputUnit`**: Tracks the unit selected by the user for output.
- **`inputExpanded`**: Boolean state to control the visibility of the input unit dropdown menu.
- **`outputExpanded`**: Boolean state to control the visibility of the output unit dropdown menu.
- **`outputUnitResult`**: Stores the result unit that is displayed with the converted value.
- **`conversionFactor`**: Represents the factor used to convert the input value to meters.
- **`outputConversionFactor`**: Represents the factor used to convert from meters to the desired output unit.

### Function: `convertUnits`

- **Purpose**: Converts the input value to the desired output unit using the conversion factors.
- **Logic**:
    - Checks if both input and output units are selected.
    - If either unit is not selected, it sets the output value to "0.0".
    - Otherwise, it performs the conversion using a formula:
    - Rounds the result to two decimal places and updates `outputValue`.

### UI Layout

- **Column**: Arranges child composables vertically with center alignment.
    - **Text**: Displays the title "Unit Converter" with custom styling.
    - **Spacer**: Adds vertical space between UI elements.
    - **OutlinedTextField**: Allows the user to input a value.
        - Customizes border colors and handles input changes.
        - Calls `convertUnits` to update the converted value on each input change.
    - **Row**: Contains input and output unit selection buttons.
        - **Box**: Contains a `Button` and `DropdownMenu` for selecting input units.
            - **DropdownMenuItem**: Each item represents a unit of measurement. Clicking an item sets the input unit and its conversion factor.
        - **Spacer**: Adds horizontal space between the input and output unit selectors.
        - **Box**: Contains a `Button` and `DropdownMenu` for selecting output units.
            - **DropdownMenuItem**: Each item represents a unit of measurement. Clicking an item sets the output unit and its conversion factor, and triggers conversion.
    - **Text**: Displays the converted value and the result unit.

### Preview

- **`UnitConverterPreview`**: A preview function annotated with `@Preview`, which allows you to visualize the `UnitConverter` composable in the IDE with a sample background.

### TODO

- **Historic Converted Values**: There is a placeholder comment indicating the intention to add functionality for storing and displaying historical conversion values.

## Usage

1. **Launch the Application**: Open the application on your Android device or emulator.

2. **Input Value**: Enter the value you want to convert in the text field labeled "Enter the value".

3. **Select Input Unit**: Tap the dropdown menu next to the input unit button to select the unit of measurement for the input value.

4. **Select Output Unit**: Tap the dropdown menu next to the output unit button to select the unit of measurement for the converted value.

5. **View Result**: The converted value will be displayed below the dropdown menus with the selected output unit.

Here are some screenshots showing the user interface of the application:

### Screenshot 1
![Unit Converter Screen](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20143939.png)

### Screenshot 2
![Dropdown Menu](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144141.png)

### Screenshot 3
![Converted Value_1](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144222.png)

### Screenshot 4
![Converted Value_2](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144237.png)

### Screenshot 5
![Converted Value_3](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144305.png)


