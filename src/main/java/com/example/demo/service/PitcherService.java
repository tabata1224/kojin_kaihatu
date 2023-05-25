package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.EditPitcherForm;
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
     * データベースからチームIDに一致する選手の一覧を取得する
     * 9
     * 
     * @return
     */
    public List<Pitcher> findTeamMenber(int teamId) {

        List<Pitcher> member = new ArrayList<>();
        for (Pitcher pitcher : repository.findAll()) {
            if (teamId == pitcher.getTeamId()) {
                member.add(pitcher);
            }
        }
        return member;
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

    // 受け取ったidからデータを取得して、Formを返却する
    public EditPitcherForm getOneFielder(Integer id) {

        // idを指定して本の情報を取得する
        Pitcher pitcher = repository.findById(id).get();
        // 画面返却用のFormに値を設定する
        EditPitcherForm editPitcher = new EditPitcherForm();
        editPitcher.setPlayerId(id);
        editPitcher.setUniformNumber(pitcher.getUniformNumber());
        editPitcher.setName(pitcher.getName());
        editPitcher.setTeamId(pitcher.getTeamId());
        editPitcher.setPitched(pitcher.getPitched());
        editPitcher.setEarnedRunsAverage(pitcher.getEarnedRunsAverage());
        editPitcher.setWin(pitcher.getWin());
        editPitcher.setLose(pitcher.getLose());
        editPitcher.setSave(pitcher.getSave());
        editPitcher.setHold(pitcher.getHold());
        editPitcher.setInningsPitched(pitcher.getInningsPitched());
        editPitcher.setStrikeOut(pitcher.getStrikeOut());

        return editPitcher;
    }

    public void update(EditPitcherForm editPitcher) {
        // データベースに登録する値を保持するインスタンス
        Pitcher pitcher = new Pitcher();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        pitcher.setPlayerId(editPitcher.getPlayerId());
        pitcher.setUniformNumber(editPitcher.getUniformNumber());
        pitcher.setName(editPitcher.getName());
        pitcher.setTeamId(editPitcher.getTeamId());
        pitcher.setPitched(editPitcher.getPitched());
        pitcher.setEarnedRunsAverage(editPitcher.getEarnedRunsAverage());
        pitcher.setWin(editPitcher.getWin());
        pitcher.setLose(editPitcher.getLose());
        pitcher.setSave(editPitcher.getSave());
        pitcher.setHold(editPitcher.getHold());
        pitcher.setInningsPitched(editPitcher.getInningsPitched());
        pitcher.setStrikeOut(editPitcher.getStrikeOut());

        // データベースに登録する
        repository.save(pitcher);
    }
}