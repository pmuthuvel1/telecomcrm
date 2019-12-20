package com.crm.telecomcrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.telecomcrm.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
