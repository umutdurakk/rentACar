package com.example.rentACar.webApi.controllers;

import com.example.rentACar.bussines.abstracts.BrandService;
import com.example.rentACar.bussines.requests.brands.CreateBrandRequest;
import com.example.rentACar.bussines.requests.brands.UpdateBrandRequest;
import com.example.rentACar.bussines.responses.brands.GetAllBrandsResponse;
import com.example.rentACar.bussines.responses.brands.GetByIdBrandsResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController{

   private BrandService brandService;


    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    GetByIdBrandsResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest){this.brandService.add(createBrandRequest);}

    @PutMapping
    public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
