package com.example.rentACar.bussines.concretes;

import com.example.rentACar.bussines.abstracts.ModelService;
import com.example.rentACar.bussines.requests.models.CreateModelRequest;
import com.example.rentACar.bussines.responses.models.GetAllModelResponse;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.ModelRepository;
import com.example.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    ModelRepository modelRepository;
    ModelMapperService mapperService;


    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> getAllModelResponses= models.stream().map
                (model->this.mapperService.forResponse()
                        .map(model, GetAllModelResponse.class)).collect(Collectors.toList());
        return getAllModelResponses;

    }

    @Override
    public void add(CreateModelRequest createModelRequest) {

        Model model = this.mapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}
