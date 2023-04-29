package com.example.rentACar.bussines.concretes;

import com.example.rentACar.bussines.abstracts.BrandService;
import com.example.rentACar.bussines.requests.brands.CreateBrandRequest;
import com.example.rentACar.bussines.requests.brands.UpdateBrandRequest;
import com.example.rentACar.bussines.responses.brands.GetAllBrandsResponse;
import com.example.rentACar.bussines.responses.brands.GetByIdBrandsResponse;
import com.example.rentACar.bussines.rules.BrandBusinessRules;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private  BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
       List<Brand> brands = brandRepository.findAll();
       List<GetAllBrandsResponse> brandsResponses = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses ;
    }

    @Override
    public GetByIdBrandsResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandsResponse response = this.modelMapperService.forResponse().map(brand,GetByIdBrandsResponse.class);

        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand =
                this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
