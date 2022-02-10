package com.example.grading.service;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    /***** Celsius *****/
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private static double celsiusToRankine(double celsius) {
        return (celsius * 9 / 5) + 491.67;
    }

    /***** Fahrenheit *****/
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    private static double fahrenheitToRankine(double fahrenheit) {
        return (fahrenheit - 32) + 491.67;
    }

    /***** Kelvin *****/
    private static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    private static double kelvinToRankine(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 491.67;
    }

    /***** Rankine *****/
    private static double rankineToCelsius(double rankine) {
        return (rankine - 491.67) * 5 / 9;
    }

    private static double rankineToFahrenheit(double rankine) {
        return (rankine - 491.67) + 32;
    }

    private static double rankineToKelvin(double rankine) {
        return (rankine - 491.67) * 5 / 9 + 273.15;
    }

    /***** Liter *****/
    private static double literToTablespoon(double liter) {
        return liter * 67.628;
    }

    private static double literToCubicInches(double liter) {
        return liter * 61.0237;
    }

    private static double literToCup(double liter) {
        return liter * 4.22675;
    }

    private static double literToCubicFeet(double liter) {
        return liter * 0.0353147;
    }

    private static double literToGallon(double liter) {
        return liter * 0.264172;
    }

    /***** Tablespoon *****/
    private static double tablespoonToLiter(double tablespoon) {
        return tablespoon / 67.628;
    }

    private static double tablespoonToCubicInches(double tablespoon) {
        return tablespoon / 61.0237;
    }

    private static double tablespoonToCup(double tablespoon) {
        return tablespoon / 4.22675;
    }

    private static double tablespoonToCubicFeet(double tablespoon) {
        return tablespoon / 0.0353147;
    }

    private static double tablespoonToGallon(double tablespoon) {
        return tablespoon / 0.264172;
    }

    /***** Cubic Inches *****/
    private static double cubicInchesToLiter(double cubicInches) {
        return cubicInches / 61.0237;
    }

    private static double cubicInchesToTablespoon(double cubicInches) {
        return cubicInches / 67.628;
    }

    private static double cubicInchesToCup(double cubicInches) {
        return cubicInches / 4.22675;
    }

    private static double cubicInchesToCubicFeet(double cubicInches) {
        return cubicInches / 0.0353147;
    }

    private static double cubicInchesToGallon(double cubicInches) {
        return cubicInches / 0.264172;
    }

    /***** Cup *****/
    private static double cupToLiter(double cup) {
        return cup / 4.22675;
    }

    private static double cupToTablespoon(double cup) {
        return cup / 67.628;
    }

    private static double cupToCubicInches(double cup) {
        return cup / 61.0237;
    }

    private static double cupToCubicFeet(double cup) {
        return cup / 0.0353147;
    }

    private static double cupToGallon(double cup) {
        return cup / 0.264172;
    }

    /***** Cubic Feet *****/
    private static double cubicFeetToLiter(double cubicFeet) {
        return cubicFeet / 0.0353147;
    }

    private static double cubicFeetToTablespoon(double cubicFeet) {
        return cubicFeet / 67.628;
    }

    private static double cubicFeetToCup(double cubicFeet) {
        return cubicFeet / 4.22675;
    }

    private static double cubicFeetToCubicInches(double cubicFeet) {
        return cubicFeet / 61.0237;
    }

    private static double cubicFeetToGallon(double cubicFeet) {
        return cubicFeet / 0.264172;
    }

    /***** Gallon *****/
    private static double gallonToLiter(double gallon) {
        return gallon / 0.264172;
    }

    private static double gallonToTablespoon(double gallon) {
        return gallon / 67.628;
    }

    private static double gallonToCup(double gallon) {
        return gallon / 4.22675;
    }

    private static double gallonToCubicFeet(double gallon) {
        return gallon / 0.0353147;
    }

    private static double gallonToCubicInches(double gallon) {
        return gallon / 61.0237;
    }

    public String convertValue(Double input, String inputUnit, String targetUnit) {
        Double result = null;
        inputUnit = WordUtils.capitalizeFully(inputUnit);
        targetUnit = WordUtils.capitalizeFully(targetUnit);
        switch (inputUnit) {
            case "Celsius":
                switch (targetUnit) {
                    case "Fahrenheit":
                        result = celsiusToFahrenheit(input);
                        break;
                    case "Kelvin":
                        result = celsiusToKelvin(input);
                        break;
                    case "Rankine":
                        result = celsiusToRankine(input);
                        break;
                    default:
                        break;
                }
                break;
            case "Fahrenheit":
                switch (targetUnit) {
                    case "Celsius":
                        result = fahrenheitToCelsius(input);
                        break;
                    case "Kelvin":
                        result = fahrenheitToKelvin(input);
                        break;
                    case "Rankine":
                        result = fahrenheitToRankine(input);
                        break;
                    default:
                        break;
                }
                break;
            case "Kelvin":
                switch (targetUnit) {
                    case "Celsius":
                        result = kelvinToCelsius(input);
                        break;
                    case "Fahrenheit":
                        result = kelvinToFahrenheit(input);
                        break;
                    case "Rankine":
                        result = kelvinToRankine(input);
                        break;
                    default:
                        break;
                }
                break;
            case "Rankine":
                switch (targetUnit) {
                    case "Celsius":
                        result = rankineToCelsius(input);
                        break;
                    case "Fahrenheit":
                        result = rankineToFahrenheit(input);
                        break;
                    case "Kelvin":
                        result = rankineToKelvin(input);
                        break;
                    default:
                        break;
                }
            case "Liter":
                switch (targetUnit) {
                    case "Tablespoon":
                        result = literToTablespoon(input);
                        break;
                    case "Cubic Inches":
                        result = literToCubicInches(input);
                        break;
                    case "Cup":
                        result = literToCup(input);
                        break;
                    case "Cubic Feet":
                        result = literToCubicFeet(input);
                        break;
                    case "Gallon":
                        result = literToGallon(input);
                        break;
                    default:
                        break;
                }
                break;
            case "Tablespoon":
                switch (targetUnit) {
                    case "Liter":
                        result = tablespoonToLiter(input);
                        break;
                    case "Cubic Inches":
                        result = tablespoonToCubicInches(input);
                        break;
                    case "Cup":
                        result = tablespoonToCup(input);
                        break;
                    case "Cubic Feet":
                       result = tablespoonToCubicFeet(input);
                        break;
                    case "Gallon":
                        result = tablespoonToGallon(input);
                        break;
                    default:
                        break;
                }
                break;
            case "Cup":
                switch (targetUnit) {
                    case "Liter":
                        result = cupToLiter(input);
                        break;
                    case "Tablespoon":
                        result = cupToTablespoon(input);
                        break;
                    case "Cubic Inches":
                        result = cupToCubicInches(input);
                        break;
                    case "Cubic Feet":
                        result = cupToCubicFeet(input);
                        break;
                    case "Gallon":
                        result = cupToGallon(input);
                        break;
                    default:
                        break;
                }
                break;
            case "Cubic Inches":
                switch (targetUnit) {
                    case "Liter":
                        result = cubicInchesToLiter(input);
                        break;
                    case "Tablespoon":
                        result = cubicInchesToTablespoon(input);
                        break;
                    case "Cup":
                        result = cubicInchesToCup(input);
                        break;
                    case "Cubic Feet":
                        result = cubicInchesToCubicFeet(input);
                        break;
                    case "Gallon":
                        result = cubicInchesToGallon(input);
                        break;
                    default:
                        break;
                }
                break;
            case "Cubic Feet":
                switch (targetUnit) {
                    case "Liter":
                        result = cubicFeetToLiter(input);
                        break;
                    case "Tablespoon":
                        result = cubicFeetToTablespoon(input);
                        break;
                    case "Cup":
                        result = cubicFeetToCup(input);
                        break;
                    case "Cubic Inches":
                        result = cubicFeetToCubicInches(input);
                        break;
                    case "Gallon":
                        result = cubicFeetToGallon(input);
                        break;
                    default:
                        break;
                }
                break;
            case "Gallon":
                switch (targetUnit) {
                    case "Liter":
                        result = gallonToLiter(input);
                        break;
                    case "Tablespoon":
                        result = gallonToTablespoon(input);
                        break;
                    case "Cup":
                        result = gallonToCup(input);
                        break;
                    case "Cubic Inches":
                        result = gallonToCubicInches(input);
                        break;
                    case "Cubic Feet":
                        result = gallonToCubicFeet(input);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        if(result != null) {
            return String.format("%.2f", result);
        }

        return null;
    }
}
