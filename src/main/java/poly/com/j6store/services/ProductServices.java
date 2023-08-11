package poly.com.j6store.services;

import org.springframework.stereotype.Service;
import poly.com.j6store.entity.Product;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductServices {
    List<Product> findAll();

    Product findById(UUID id);

    List<Product> findByCategoryId(UUID cid);
}
