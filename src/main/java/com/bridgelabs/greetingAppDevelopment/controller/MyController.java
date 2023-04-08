package com.bridgelabs.greetingAppDevelopment.controller;

import com.bridgelabs.greetingAppDevelopment.dto.MyDTO;
import com.bridgelabs.greetingAppDevelopment.model.Mymodel;
import com.bridgelabs.greetingAppDevelopment.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private MyRepo myRepo;
    @PostMapping("/")
    public Mymodel addEmployee(@RequestBody MyDTO mydto){
        Mymodel data = new Mymodel(mydto);

        return myRepo.save(data);
    }


    @GetMapping("/greeting")
    public String greeting(){
        return "Hi Word ";
    }


}
