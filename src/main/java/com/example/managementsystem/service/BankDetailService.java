package com.example.managementsystem.service;

import com.example.managementsystem.entity.BankDetails;
import com.example.managementsystem.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankDetailService {

    @Autowired
    BankRepo errorRepo;

    public List<BankDetails> getdetails(){
        return errorRepo.findAll();
    }

    public String postdetails(BankDetails errorTable){
        errorRepo.save(errorTable);
        return "added";
    }

    public String putdetails(Long id,BankDetails errorTable){
        BankDetails stud = errorRepo.getById(id);

        if(errorTable.getId() != null)
        {
            stud.setId(errorTable.getId());
        }
        if(errorTable.getBankName() != null)
        {
            stud.setBankName(errorTable.getBankName());
        }
        if(errorTable.getAccontNumber() != null)
        {
            stud.setAccontNumber(errorTable.getAccontNumber());
        }
        if(errorTable.getIfscCode() != null)
        {
            stud.setIfscCode(errorTable.getIfscCode());
        }
        if(errorTable.getBranch() != null)
        {
            stud.setBranch(errorTable.getBranch());
        }
        if(errorTable.getAccoutType() != null)
        {
            stud.setAccoutType(errorTable.getAccoutType());
        }

        errorRepo.save(stud);
        return "updated";
    }

    public String deletedetails(Long id){
        errorRepo.deleteById(id);
        return "deleted";
    }

}
