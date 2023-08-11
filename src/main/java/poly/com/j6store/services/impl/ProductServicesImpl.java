package poly.com.j6store.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.com.j6store.entity.Product;
import poly.com.j6store.repo.ProductRepo;
import poly.com.j6store.services.ProductServices;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    ProductRepo productRepo;


    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(UUID id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(UUID cid) {
        return productRepo.findByCategoryId(cid);
    }
}
