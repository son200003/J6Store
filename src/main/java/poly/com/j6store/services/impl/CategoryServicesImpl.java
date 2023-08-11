package poly.com.j6store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.com.j6store.entity.Category;
import poly.com.j6store.repo.CategoryRepo;
import poly.com.j6store.services.CategoryServices;

import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices {

    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll() ;
    }
}
