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

import com.crm.telecomcrm.entities.LoginDetail;
import com.crm.telecomcrm.repositories.LoginDetailRepository;

@RestController
@RequestMapping("/logindetail")
public class LoginDetailController {

	@Autowired
	private LoginDetailRepository loginDetailRepository;
	
	@GetMapping("/all")
    public ResponseEntity<List<LoginDetail>> findAll() {
        return ResponseEntity.ok(loginDetailRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<LoginDetail> create(@Valid @RequestBody LoginDetail loginDetail) {
        return ResponseEntity.ok(loginDetailRepository.save(loginDetail));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<LoginDetail> findById(@PathVariable Long id) {
        Optional<LoginDetail> configMasterOptional = loginDetailRepository.findById(id);
        if (!configMasterOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(configMasterOptional.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LoginDetail> update(@PathVariable Long id, @Valid @RequestBody LoginDetail loginDetail) {
        if (!loginDetailRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(loginDetailRepository.save(loginDetail));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!loginDetailRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        loginDetailRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
