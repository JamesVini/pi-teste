package com.senac.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.projeto.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
