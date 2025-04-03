package com.learning.exproductservice.Controller;

import com.learning.exproductservice.Exception.ProductNotFoundException;
import com.learning.exproductservice.Model.Product;
import com.learning.exproductservice.Repository.prdsvcRepository;
import com.learning.exproductservice.Service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
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
public class prdsvcController {

    final private ProductService productService;
    public prdsvcController(ProductService productService) {
        this.productService = productService;
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

    @GetMapping("/getproduct1")
    public Product getProduct1(@RequestParam int id) {
        Optional<Product> product = repo.findById(id);
        return product.orElse(null);
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
        product.setPrdprice("15000");
        repo.save(product);
        return new ResponseEntity<String>("New product added succesfully",HttpStatus.OK);
    }

    //Validation Demo

    @PostMapping("/addproduct1")
    public ResponseEntity<String> addProduct1(@Valid @RequestBody Product product) {
        repo.save(product);
        return new ResponseEntity<String>("New product added succesfully through URI",HttpStatus.OK);
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

    //Pagination
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getAllProducts(@PageableDefault(size=2) Pageable pageable){
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }

    //Filtering
    @GetMapping("/search")
    public ResponseEntity<Page<Product>> searchProduct(@RequestParam(required = true) String prdname,Pageable pageable) {
        return ResponseEntity.ok(productService.filterProducts(prdname,pageable));
    }

    //Spring Cloud Demonstration

    private static final String ordsvc_API="http://localhost:8091/api/placeorder";
    int attempt=0;

    @GetMapping("/chooseproduct/{id}")
    //@Retry(name="fss1", fallbackMethod = "fallback")
    @CircuitBreaker(name="fss2", fallbackMethod = "fallback")
    public ResponseEntity<String> chooseProduct(@PathVariable int id) {
      //  System.out.println("Product chosen for place the order "+attempt++);// demo for retry
        Optional<Product> product = repo.findById(id);
        ResponseEntity<String> response=restTemplate.postForEntity(ordsvc_API,product,String.class);
        System.out.println("Order placed successfully");// demo
        return response;
    }
// Fallback method created for @Retry and @CircuitBreaker
    public ResponseEntity<String> fallback(Throwable ex) {
        return new ResponseEntity<>("Order unable to placed due to server issues", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
