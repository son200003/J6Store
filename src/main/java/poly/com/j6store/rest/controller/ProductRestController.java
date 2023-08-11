package poly.com.j6store.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.com.j6store.entity.Product;
import poly.com.j6store.services.ProductServices;

import java.util.UUID;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

    @Autowired
    ProductServices productServices;

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        return productServices.findById(uuid);
    }
}
