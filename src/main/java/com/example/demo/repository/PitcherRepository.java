package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pitcher;

public interface PitcherRepository extends JpaRepository<Pitcher, Integer> {
    // 全選手を背番号で昇順
    List<Pitcher> findAllByOrderByUniformNumberAsc();

    // 選択チーム選手を背番号で昇順
    List<Pitcher> findByTeamIdOrderByUniformNumberAsc(Integer teamId);

    // 全選手を登板で降順
    List<Pitcher> findAllByOrderByPitchedDesc();

    // 選択チーム選手を登板で降順
    List<Pitcher> findByTeamIdOrderByPitchedDesc(Integer teamId);

    // 全選手を防御率で昇順
    List<Pitcher> findAllByOrderByEarnedRunsAverageAsc();

    // 選択チーム選手を防御率で昇順
    List<Pitcher> findByTeamIdOrderByEarnedRunsAverageAsc(Integer teamId);

    // 全選手を勝ちで降順
    List<Pitcher> findAllByOrderByWinDesc();

    // 選択チーム選手を勝ちで降順
    List<Pitcher> findByTeamIdOrderByWinDesc(Integer teamId);

    // 全選手を負けで降順
    List<Pitcher> findAllByOrderByLoseDesc();

    // 選択チーム選手を負けで降順
    List<Pitcher> findByTeamIdOrderByLoseDesc(Integer teamId);

    // 全選手をセーブで降順
    List<Pitcher> findAllByOrderBySaveDesc();

    // 選択チーム選手をセーブで降順
    List<Pitcher> findByTeamIdOrderBySaveDesc(Integer teamId);

    // 全選手をホールドで降順
    List<Pitcher> findAllByOrderByHoldDesc();

    // 選択チーム選手をホールドで降順
    List<Pitcher> findByTeamIdOrderByHoldDesc(Integer teamId);

    // 全選手を投球回で降順
    List<Pitcher> findAllByOrderByInningsPitchedDesc();

    // 選択チーム選手を投球回で降順
    List<Pitcher> findByTeamIdOrderByInningsPitchedDesc(Integer teamId);

    // 全選手を奪三振で降順
    List<Pitcher> findAllByOrderByStrikeOutDesc();

    // 選択チーム選手を奪三振で降順
    List<Pitcher> findByTeamIdOrderByStrikeOutDesc(Integer teamId);
}
