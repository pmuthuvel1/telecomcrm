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

import com.crm.telecomcrm.entities.ProductSale;
import com.crm.telecomcrm.repositories.ProductSaleRepository;

@RestController
@RequestMapping("/productsale")
public class ProductSaleController {
	
	@Autowired
	private ProductSaleRepository productSaleRepository;
	
	@GetMapping("/all")
    public ResponseEntity<List<ProductSale>> findAll() {
        return ResponseEntity.ok(productSaleRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ProductSale> create(@Valid @RequestBody ProductSale productSale) {
        return ResponseEntity.ok(productSaleRepository.save(productSale));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProductSale> findById(@PathVariable Long id) {
        Optional<ProductSale> configMasterOptional = productSaleRepository.findById(id);
        if (!configMasterOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(configMasterOptional.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductSale> update(@PathVariable Long id, @Valid @RequestBody ProductSale productSale) {
        if (!productSaleRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(productSaleRepository.save(productSale));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!productSaleRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        productSaleRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
