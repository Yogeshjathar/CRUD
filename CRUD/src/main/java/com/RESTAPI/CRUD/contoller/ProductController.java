package com.RESTAPI.CRUD.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.RESTAPI.CRUD.entities.Product;
import com.RESTAPI.CRUD.models.ProductModel;
import com.RESTAPI.CRUD.models.ProductRes;
import com.RESTAPI.CRUD.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductRes> getAllProducts(@RequestParam("page") Integer page) {
        return productService.getAllProducts(0, page);
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductModel product) {
    	Product product2 = new Product();
    	product2.setName(product.getName());
    	product2.setPrice(product.getPrice());
    	product2.setCategory(product.getCategory());
        return productService.createProduct(product2);
    }

    @GetMapping("/{id}")
    public ProductRes getProductById(@PathVariable("id") Integer id) {
    	 return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return "product Id " + id +" updated";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return "Product deleted successfully.";
    }
}
