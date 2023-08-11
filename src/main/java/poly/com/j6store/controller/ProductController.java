package poly.com.j6store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.com.j6store.entity.Product;
import poly.com.j6store.services.ProductServices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    ProductServices productServices;


        @RequestMapping("/product/list")
        public String list(Model model, @RequestParam("cid")Optional<UUID> cid ){
            if(cid.isPresent()){
                List<Product> list = productServices.findByCategoryId(cid.get());
                model.addAttribute("items", list);
            }
            else{
                List<Product> list = productServices.findAll();
                model.addAttribute("items", list);
            }
            return "product/list";
        }

        @RequestMapping("/product/detail/{id}")
        public String detail(Model model, @PathVariable("id")UUID id){
            Product item = productServices.findById(id);
            model.addAttribute("item", item);
            return "product/detail";
        }
    }


