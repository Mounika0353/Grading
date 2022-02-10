package com.example.grading.controller;

import com.example.grading.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {
    private final ConversionService conversionService;

    @Autowired
    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/convert")
    public String convert(@RequestParam Double inputValue, @RequestParam String inputUnit, @RequestParam String outputUnit) {
        return conversionService.convertValue(inputValue, inputUnit, outputUnit);
    }
}
