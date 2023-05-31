package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CLFielder;

public interface CLFielderRepository extends JpaRepository<CLFielder, Integer> {

    // 全選手を打順で昇順
    List<CLFielder> findAllByOrderByOrderNumAsc();
}
