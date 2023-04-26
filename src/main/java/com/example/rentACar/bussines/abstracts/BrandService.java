package com.example.rentACar.bussines.abstracts;

import com.example.rentACar.bussines.requests.CreateBrandRequest;
import com.example.rentACar.bussines.requests.UpdateBrandRequest;
import com.example.rentACar.bussines.responses.GetAllBrandsResponse;
import com.example.rentACar.bussines.responses.GetByIdBrandsResponse;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandsResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
