package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pitcher;

public interface PitcherBaseBallRepository extends JpaRepository<Pitcher, Integer> {

}
