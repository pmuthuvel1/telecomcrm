package com.crm.telecomcrm.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.telecomcrm.entities.Product;
import com.crm.telecomcrm.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> configMasterOptional = productRepository.findById(id);
        if (!configMasterOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(configMasterOptional.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        if (!productRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(productRepository.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!productRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        productRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
