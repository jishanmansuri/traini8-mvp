package com.example.traini8.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Address {
    @NotBlank(message = "Detailed Address is required")
    private String detailedAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Pincode is required")
    private String pincode;
}
