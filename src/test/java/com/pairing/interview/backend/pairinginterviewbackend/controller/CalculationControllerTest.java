package com.pairing.interview.backend.pairinginterviewbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pairing.interview.backend.pairinginterviewbackend.model.Invoice;
import com.pairing.interview.backend.pairinginterviewbackend.model.TaxCalculation;
import com.pairing.interview.backend.pairinginterviewbackend.service.CalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CalculationControllerTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculationController calculationController;

    private MockMvc mockMvc;

    ObjectMapper objectMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(calculationController)
                .build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void calculateTax() throws Exception {
        Invoice invoice = Invoice.builder().price(100.0).quantity(1).zipCode("30339").build();
        TaxCalculation taxCalculation = TaxCalculation.builder().invoice(invoice).build();

        String json = new ObjectMapper().writeValueAsString(taxCalculation);

        when(calculatorService.determineTaxByZip(any())).thenReturn(taxCalculation);

        mockMvc.perform(
                post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();
    }
}
