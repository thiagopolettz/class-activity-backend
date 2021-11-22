package com.classactivity.classactivity.controller;

import com.classactivity.classactivity.entities.Products;
import com.classactivity.classactivity.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductsController {

    @Autowired
    private ProductsRepository repository;

    @PostMapping
    public ResponseEntity<Products> save(@RequestBody Products products) {
        Products pS = repository.save(products);
        return ResponseEntity.ok(pS);
    }

    @GetMapping
    public ResponseEntity<List<Products>> get() {
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{productsId}")
    public ResponseEntity delete(@PathVariable("productsId") long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
