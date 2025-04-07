package com.example.SashankaDemo.Controller;


import com.example.SashankaDemo.Exception.ProductNotFoundException;
import com.example.SashankaDemo.Model.Product;
import com.example.SashankaDemo.Repository.prdsvcRepository;
import com.example.SashankaDemo.Service.Demoservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DemoController {

    final private Demoservice demoservice;
    public DemoController(Demoservice demoservice) {
        this.demoservice = demoservice;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @Autowired
    private prdsvcRepository repo;

    @GetMapping("/welcome")
    public String api() {
        return environment.getProperty("welcome.msg");
    }

    @RequestMapping(path="/index", method= RequestMethod.GET)
    public String index() {
        return "Welcome to Product Service";
    }

    @GetMapping("/count")
    public ResponseEntity<String> count() {
        long count = repo.count();
        return new ResponseEntity<>("Count of product is:"+count, HttpStatus.OK);
    }


    @GetMapping("/getcount")
    public Long getcount()
    {
        return repo.count();
    }

    @GetMapping("/productss")
    public Iterable<Product> getProducts() {
        Iterable<Product> products = repo.findAll();
        return products;
    }


    //Exception handling
    @GetMapping("/getproduct2/{id}")
    public Product getProduct2(@PathVariable int id) {
        Optional<Product> product = repo.findById(id);
        return product.orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct() {
        Product product = new Product();
        product.setPrdname("Apple 14");
        product.setPrdcount("5");
        product.setPrddescription("Applie mobile devices");
        product.setPrdprice("15000.00");
        repo.save(product);
        return new ResponseEntity<String>("New product added succesfully",HttpStatus.OK);
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product product1 = repo.findById(id).orElseThrow();
        product1.setPrdname(product.getPrdname());
        product1.setPrdcount(product.getPrdcount());
        product1.setPrddescription(product.getPrddescription());
        product1.setPrdprice(product.getPrdprice());
        repo.save(product1);
        return new ResponseEntity<>("Product Details updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        repo.deleteById(id);
        return new ResponseEntity<String>("Product deleted successfully",HttpStatus.OK);
    }

    //Pagination of the data
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getAllProducts(@PageableDefault(size=2) Pageable pageable){
        return ResponseEntity.ok(demoservice.getAllProducts(pageable));
    }

    //Filtering the data
    @GetMapping("/search")
    public ResponseEntity<Page<Product>> searchProduct(@RequestParam(required = true) String prdname,Pageable pageable) {
        return ResponseEntity.ok(demoservice.filterProducts(prdname,pageable));
    }

}
