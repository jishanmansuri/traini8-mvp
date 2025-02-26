package com.example.traini8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Entity
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    private Long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    private String contactPhone;

    @PrePersist
    public void setCreationTimestamp() {
        this.createdOn = Instant.now().getEpochSecond();
    }
}
