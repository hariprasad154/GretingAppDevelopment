package com.bridgelabs.greetingAppDevelopment.controller;

import com.bridgelabs.greetingAppDevelopment.dto.MyDTO;
import com.bridgelabs.greetingAppDevelopment.model.Mymodel;
import com.bridgelabs.greetingAppDevelopment.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MyController {

    @GetMapping("/greeting")
    public String greeting(){
        return "Hi Word ";
    }

}
