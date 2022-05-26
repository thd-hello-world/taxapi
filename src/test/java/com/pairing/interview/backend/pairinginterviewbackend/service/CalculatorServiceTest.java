package com.pairing.interview.backend.pairinginterviewbackend.service;

import com.pairing.interview.backend.pairinginterviewbackend.model.Invoice;
import com.pairing.interview.backend.pairinginterviewbackend.model.TaxCalculation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CalculatorServiceTest {

    CalculatorService calculatorService;

    @Before
    public void setup() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void calculateTaxByZip30339() {
        Invoice invoice = Invoice.builder().price(100.0).quantity(1).zipCode("30339").build();
        TaxCalculation taxCalculation = TaxCalculation.builder().invoice(invoice).build();

        Double expectedTaxAmount = 6.0;
        TaxCalculation actualCalculationJson = calculatorService.determineTaxByZip(taxCalculation);

        assertEquals(actualCalculationJson.getInvoice().getTaxAmount(), expectedTaxAmount);
    }
}