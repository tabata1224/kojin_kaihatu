package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CLPitcher;

public interface CLPitcherRepository extends JpaRepository<CLPitcher, Integer> {
    // 全選手を背番号で昇順
    List<CLPitcher> findAllByOrderByUniformNumberAsc();

}
