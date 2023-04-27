package com.example.rentACar.webApi.controllers;

import com.example.rentACar.bussines.abstracts.ModelService;
import com.example.rentACar.bussines.requests.models.CreateModelRequest;
import com.example.rentACar.bussines.responses.models.GetAllModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {
    ModelService modelService;

    @Autowired
    public ModelsController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping()
    List<GetAllModelResponse> getAll(){return modelService.getAll();}


    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    void Add(CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }



}
