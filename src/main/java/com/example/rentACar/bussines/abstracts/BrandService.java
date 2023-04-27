package com.example.rentACar.bussines.abstracts;

import com.example.rentACar.bussines.requests.brands.CreateBrandRequest;
import com.example.rentACar.bussines.requests.brands.UpdateBrandRequest;
import com.example.rentACar.bussines.responses.brands.GetAllBrandsResponse;
import com.example.rentACar.bussines.responses.brands.GetByIdBrandsResponse;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandsResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
