package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pitcher;

public interface PitcherBaseBallRepository extends JpaRepository<Pitcher, Integer> {
    // 全選手を背番号で昇順
    List<Fielder> findAllByOrderByUniformNumberAsc();

    // 選択チーム選手を背番号で昇順
    List<Fielder> findByTeamIdOrderByUniformNumberAsc(Integer teamId);
}
