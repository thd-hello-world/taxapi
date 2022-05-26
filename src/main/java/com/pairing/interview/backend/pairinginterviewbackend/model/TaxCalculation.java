package com.pairing.interview.backend.pairinginterviewbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaxCalculation {

    @JsonProperty("invoice")
    private Invoice invoice;
}
