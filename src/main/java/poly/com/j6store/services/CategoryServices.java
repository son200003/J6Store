package poly.com.j6store.services;


import org.springframework.stereotype.Service;
import poly.com.j6store.entity.Category;

import java.util.List;

@Service
public interface CategoryServices {
    List<Category> findAll();

}
