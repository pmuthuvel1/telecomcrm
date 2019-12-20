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

import com.crm.telecomcrm.entities.ConfigMaster;
import com.crm.telecomcrm.repositories.ConfigMasterRepository;

@RestController
@RequestMapping("/confmaster")
public class ConfigMasterController {

	@Autowired
	private ConfigMasterRepository configMasterRepository;
	
	@GetMapping("/all")
    public ResponseEntity<List<ConfigMaster>> findAll() {
        return ResponseEntity.ok(configMasterRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ConfigMaster> create(@Valid @RequestBody ConfigMaster configMaster) {
        return ResponseEntity.ok(configMasterRepository.save(configMaster));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ConfigMaster> findById(@PathVariable Long id) {
        Optional<ConfigMaster> configMasterOptional = configMasterRepository.findById(id);
        if (!configMasterOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(configMasterOptional.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConfigMaster> update(@PathVariable Long id, @Valid @RequestBody ConfigMaster configMaster) {
        if (!configMasterRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(configMasterRepository.save(configMaster));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!configMasterRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        configMasterRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
