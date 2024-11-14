package com.projeto.cafeteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.cafeteria.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
