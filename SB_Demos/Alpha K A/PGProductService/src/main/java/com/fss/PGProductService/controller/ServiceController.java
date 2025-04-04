package com.fss.PGProductService.controller;

import com.fss.PGProductService.exceptionHandling.ServiceNotFOundException;
import com.fss.PGProductService.model.Service;
import com.fss.PGProductService.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ServiceController {



    @Autowired
    private Environment environment;

    @Autowired
    private ServiceRepository repo;

    @GetMapping("/welcome")
    public String api() {
        return environment.getProperty("welcome.msg");
    }

    @RequestMapping(path="/index", method= RequestMethod.GET)
    public String index() {
        return "Welcome to Services";
    }

    @GetMapping("/count")
    public ResponseEntity<String> count() {
        long count = repo.count();
        //return new ResponseEntity<>("Count of product is:"+count, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body("Count of service is:"+count);
    }

    @GetMapping("/getcount")
    public Long getcount()
    {
        return repo.count();
    }

    @GetMapping("/products")
    public Iterable<Service> getProducts() {
        Iterable<Service> services = repo.findAll();
        return services;
    }

    @GetMapping("/getService1")
    public Service getService1(@RequestParam long id) {
        Optional<Service> service = repo.findById(id);
        return service.orElse(null);
    }
    //Exception handling
    @GetMapping("/getService2/{id}")
    public Service getService2(@PathVariable long id) {
        Optional<Service> service = repo.findById(id);
        return service.orElseThrow(() -> new ServiceNotFOundException(id));
    }

    @PostMapping("/addService")
    public ResponseEntity<String> addService() {
        Service service = new Service();
        service.setId(1);
        service.setName("Service");
        service.setAmount(2000);
        service.setDescription("Service Desc");
        repo.save(service);
        return new ResponseEntity<String>("New service added succesfully",HttpStatus.OK);
    }

    @PostMapping("/addService1")
    public ResponseEntity<String> addProduct1(@RequestBody Service service) {
        repo.save(service);
        return new ResponseEntity<String>("New service added succesfully through URI",HttpStatus.OK);
    }


    @DeleteMapping("/deleteService/{id}")
    public ResponseEntity<String> deleteService(@PathVariable long id) {
        repo.deleteById(id);
        return new ResponseEntity<String>("Service deleted successfully",HttpStatus.OK);
    }

}
