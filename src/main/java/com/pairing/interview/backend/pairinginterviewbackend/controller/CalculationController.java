package com.pairing.interview.backend.pairinginterviewbackend.controller;

import com.pairing.interview.backend.pairinginterviewbackend.model.TaxCalculation;
import com.pairing.interview.backend.pairinginterviewbackend.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class CalculationController {

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(method = RequestMethod.POST,
            path = "/calculate",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TaxCalculation> calculateTax(@RequestBody TaxCalculation taxCalculation) {

        calculatorService.determineTaxByZip(taxCalculation);

        return ResponseEntity.ok(taxCalculation);
    }
}