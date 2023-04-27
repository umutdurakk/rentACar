package com.example.rentACar.bussines.abstracts;

import com.example.rentACar.bussines.requests.models.CreateModelRequest;
import com.example.rentACar.bussines.responses.models.GetAllModelResponse;
import com.example.rentACar.entities.concretes.Model;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}
