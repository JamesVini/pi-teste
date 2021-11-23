package com.senac.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.projeto.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {


}
