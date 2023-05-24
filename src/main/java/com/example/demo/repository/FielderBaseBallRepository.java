package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Fielder;

public interface FielderBaseBallRepository extends JpaRepository<Fielder, Integer> {

}
