package com.pairing.interview.backend.pairinginterviewbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invoice {

    @JsonProperty("price")
    private Double price;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("taxAmount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double taxAmount;
}
