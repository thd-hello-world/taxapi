package com.pairing.interview.backend.pairinginterviewbackend.service;

import com.pairing.interview.backend.pairinginterviewbackend.model.TaxCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    public CalculatorService() {}

    public TaxCalculation determineTaxByZip(TaxCalculation taxCalculation) {

        String zipCode = taxCalculation.getInvoice().getZipCode();
        Double taxRate;
        switch (zipCode) {
            case "30815":
                taxRate = 0.08;
                break;
            case "30149":
                taxRate = 0.07;
                break;
            case "30339":
                taxRate = 0.06;
                break;
            default:
                taxRate = 0.04;
                break;
        }

        Double price = taxCalculation.getInvoice().getPrice();

        Double taxAmount = (price * taxRate);

        taxCalculation.getInvoice().setTaxAmount(taxAmount);

        return taxCalculation;
    }

}