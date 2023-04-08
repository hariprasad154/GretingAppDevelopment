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


    @GetMapping("/{id}")
    public String getEmployee(@PathVariable long id) {
        Optional<Mymodel> data = myRepo.findById(id);
        String greeting="no Data Found";
        if (data.isPresent()) {
            greeting = data.get().getFirstName() + data.get().getLastName() + data.get().getGreeting();

        }
        return greeting;
    }

    @GetMapping("/greeting")
    public String greeting(){
        return "Hi Word ";
    }


}
