package com.bridgelabs.greetingAppDevelopment.controller;

import com.bridgelabs.greetingAppDevelopment.dto.MyDTO;
import com.bridgelabs.greetingAppDevelopment.model.Mymodel;
import com.bridgelabs.greetingAppDevelopment.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Service
public class MyController {

    @Autowired
    private MyRepo myRepo;

    public List<Mymodel> getalldata() {
        List<Mymodel> data = new ArrayList<>();
        myRepo.findAll().forEach(datas -> data.add(datas));
        return data;
    }

    public void saveorUpdate(MyDTO mydto) {
        Mymodel data = new Mymodel(mydto);
        myRepo.save(data);
    }

    @PutMapping("/put/{id}")
    public Mymodel update(@RequestBody MyDTO mydto, @PathVariable long id) {
        Optional<Mymodel> data = myRepo.findById(id);
        if (data.isPresent()) {
            data.get().setFirstName(mydto.firstName);
            data.get().setLastName(mydto.lastName);
            data.get().setGreeting(mydto.greeting);

            return myRepo.save(data.get());
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String delet(@PathVariable long id) {
        Optional<Mymodel> data = myRepo.findById(id);
        if (data.isPresent()) {
            myRepo.deleteById(id);
            return "The deleting done" +id;
        }
        return null;
    }


    @GetMapping("/get")
    public List<Mymodel> getall(){
        return getalldata();
    }
    @PostMapping("/")
    public Mymodel addEmployee(@RequestBody MyDTO mydto){
        Mymodel data = new Mymodel(mydto);

        return myRepo.save(data);
    }




    @GetMapping("/greeting")
    public String greeting(){
        return "Hi Word ";
    }
    @GetMapping("/{id}")
    public String getEmployee(@PathVariable long id) {
        Optional<Mymodel> data = myRepo.findById(id);
        String greeting="no Data Found";
        if (data.isPresent()) {
            greeting =data.get().getGreeting()+" " + data.get().getFirstName() + " "+data.get().getLastName() ;

        }
        return greeting;
    }




}
