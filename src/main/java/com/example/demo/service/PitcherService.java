package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.PitcherForm;
import com.example.demo.model.Pitcher;
import com.example.demo.repository.PitcherBaseBallRepository;

@Service
@Transactional
public class PitcherService {
    @Autowired
    PitcherBaseBallRepository repository;

    /**
     * データベースから選手の一覧を取得する
     * 
     * @return
     */

    public List<Pitcher> findAll() {
        return repository.findAll();
    }

    /**
     * データベースにデータを登録する
     * 
     * @return
     */

    public void insert(PitcherForm pitcherForm) {
        // データベースに登録する値を保持するインスタンス
        Pitcher pitcher = new Pitcher();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        pitcher.setUniformNumber(pitcherForm.getUniformNumber());
        pitcher.setName(pitcherForm.getName());
        pitcher.setTeamId(pitcherForm.getTeamId());
        pitcher.setPitched(pitcherForm.getPitched());
        pitcher.setEarnedRunsAverage(pitcherForm.getEarnedRunsAverage());
        pitcher.setWin(pitcherForm.getWin());
        pitcher.setLose(pitcherForm.getLose());
        pitcher.setSave(pitcherForm.getSave());
        pitcher.setHold(pitcherForm.getHold());
        pitcher.setInningsPitched(pitcherForm.getInningsPitched());
        pitcher.setStrikeOut(pitcherForm.getStrikeOut());

        // データベースに登録する
        repository.save(pitcher);
    }

    // 投手を削除する
    public void delete(Integer id) {

        // idを指定して、データベースからデータを削除する
        repository.deleteById(id);
    }
}