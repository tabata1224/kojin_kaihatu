package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Fielder;

public interface FielderRepository extends JpaRepository<Fielder, Integer> {
    // 全選手を背番号で昇順
    List<Fielder> findAllByOrderByUniformNumberAsc();

    // 選択チーム選手を背番号で昇順
    List<Fielder> findByTeamIdOrderByUniformNumberAsc(Integer teamId);

    // 全選手を打順で昇順
    List<Fielder> findAllByOrderByOrderNumAsc();

    // 選択チームを打順で昇順
    List<Fielder> findByTeamIdOrderByOrderNumAsc(Integer teamId);

    // 全選手を打率で降順
    List<Fielder> findAllByOrderByBattingAverageDesc();

    // 選択チームを打率で降順
    List<Fielder> findByTeamIdOrderByBattingAverageDesc(Integer teamId);

    // 全選手を安打で降順
    List<Fielder> findAllByOrderByHitDesc();

    // 選択チームを安打で降順
    List<Fielder> findByTeamIdOrderByHitDesc(Integer teamId);

    // 全選手を二塁打で降順
    List<Fielder> findAllByOrderByDoubleHitDesc();

    // 選択チームを二塁打で降順
    List<Fielder> findByTeamIdOrderByDoubleHitDesc(Integer teamId);

    // 全選手を三塁打で降順
    List<Fielder> findAllByOrderByThreeHitDesc();

    // 選択チームを三塁打で降順
    List<Fielder> findByTeamIdOrderByThreeHitDesc(Integer teamId);

    // 全選手を本塁打で降順
    List<Fielder> findAllByOrderByHomerunDesc();

    // 選択チームを本塁打で降順
    List<Fielder> findByTeamIdOrderByHomerunDesc(Integer teamId);

    // 全選手を打点で降順
    List<Fielder> findAllByOrderByRunBattedInDesc();

    // 選択チームを打点で降順
    List<Fielder> findByTeamIdOrderByRunBattedInDesc(Integer teamId);

    // 全選手を盗塁で降順
    List<Fielder> findAllByOrderByBaseStealingDesc();

    // 選択チームを盗塁で降順
    List<Fielder> findByTeamIdOrderByBaseStealingDesc(Integer teamId);
}
