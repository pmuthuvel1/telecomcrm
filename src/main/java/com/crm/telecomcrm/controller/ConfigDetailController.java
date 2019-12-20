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

import com.crm.telecomcrm.entities.ConfigDetail;
import com.crm.telecomcrm.repositories.ConfigDetailRepository;

@RestController
@RequestMapping("/confdetail")
public class ConfigDetailController {

	@Autowired 
	private ConfigDetailRepository configDetailRepository;

    @GetMapping("/all")
    public ResponseEntity<List<ConfigDetail>> findAll() {
        return ResponseEntity.ok(configDetailRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ConfigDetail> create(@Valid @RequestBody ConfigDetail configDetail) {
        return ResponseEntity.ok(configDetailRepository.save(configDetail));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ConfigDetail> findById(@PathVariable Long id) {
        Optional<ConfigDetail> configDetailOptional = configDetailRepository.findById(id);
        if (!configDetailOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(configDetailOptional.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConfigDetail> update(@PathVariable Long id, @Valid @RequestBody ConfigDetail configDetail) {
        if (!configDetailRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(configDetailRepository.save(configDetail));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!configDetailRepository.findById(id).isPresent()) {
        	System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        configDetailRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    
}
