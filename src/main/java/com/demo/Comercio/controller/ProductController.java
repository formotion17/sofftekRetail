package com.demo.Comercio.controller;

import com.demo.Comercio.model.dto.product.ProductFindRequest;
import com.demo.Comercio.model.dto.product.ProductFindResponse;
import com.demo.Comercio.model.entity.Product;
import com.demo.Comercio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("product")
    public ProductFindResponse findProductById(@Valid @RequestBody ProductFindRequest product) throws ParseException {
        return productService.findProductById(product);
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}
