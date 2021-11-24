package com.senac.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.projeto.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
