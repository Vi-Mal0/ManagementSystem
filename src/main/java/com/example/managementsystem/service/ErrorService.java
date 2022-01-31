package com.example.managementsystem.service;

import com.example.managementsystem.entity.ErrorTable;
import com.example.managementsystem.repository.ErrorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorService {

    @Autowired
    ErrorRepo errorRepo;

    public String DATAEXIST(){
        return errorRepo.getById(300L).getName();
    }

    public String DATANOTFOUND(){
        return errorRepo.getById(404L).getName();
    }

    public String BADREQUEST(){
        return errorRepo.getById(400L).getName();
    }

    public String createError(ErrorTable error){
        errorRepo.save(error);
        return "error created";
    }

    public String deleteErrorByID(Long id){
        errorRepo.deleteById(id);
        return "deleted";
    }

    public String updateError(Long id, ErrorTable error){

        ErrorTable errorTable = errorRepo.getById(id);

        if(error.getName() != null)
        {
            errorTable.setName(error.getName());
            errorRepo.save(errorTable);
        }

        return "updated";

    }

    public List<ErrorTable> viewError(){
        return errorRepo.findAll();
    }

    public Optional<ErrorTable> viewErrorByID(Long id){
        return errorRepo.findById(id);
    }


}
