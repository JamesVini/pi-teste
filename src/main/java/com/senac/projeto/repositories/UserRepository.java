package com.senac.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.projeto.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {


}
