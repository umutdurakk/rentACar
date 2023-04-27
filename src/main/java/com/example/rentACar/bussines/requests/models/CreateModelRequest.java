package com.example.rentACar.bussines.requests.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull
    @NotBlank
    @Size(min = 2,max = 20)
    private String name;

    @NotNull
    @NotBlank
    private int brandId;
}
