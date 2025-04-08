package com.example.firstdemo.firstdemo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/test")
public class demo {

    @Autowired
    respositoryDB repo;


    @GetMapping("/demo")
    public String name(){
        return "hello";
    }
    @PostMapping("/addDemo")
    public ResponseEntity<String> addDemo(){
        model modelDemo = new model();
        modelDemo.setName("test");
        modelDemo.setUserName("usertest");
        repo.save(modelDemo);
        return new ResponseEntity<String>("Sucessfully insert/update", HttpStatus.OK);
    }

    @PostMapping("/addDemoone")
    public ResponseEntity<String> addDemoJson(@RequestBody @Valid  model modelDemo){
        repo.save(modelDemo);
        return new ResponseEntity<String>("Successfully insert/update through josn",HttpStatus.OK);
    }
    @DeleteMapping("/deletedemo/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        repo.deleteById(id);
        return new ResponseEntity<String>("Product deleted successfully",HttpStatus.OK);
    }

    @GetMapping("/getDemo/{id}")
    public model getDemo(@PathVariable int id) {
        Optional<model> optionalModel = repo.findById(id);
        return optionalModel.orElseThrow(() ->new NotfoundException(id));
    }
}
