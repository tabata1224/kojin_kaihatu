package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.EditFielderForm;
import com.example.demo.form.FielderForm;
import com.example.demo.model.Fielder;
import com.example.demo.repository.FielderBaseBallRepository;

@Service
@Transactional
public class FielderService {
    @Autowired
    FielderBaseBallRepository repository;

    /**
     * データベースから選手の一覧を取得する
     * 
     * @return
     */

    public List<Fielder> findAll() {
        return repository.findAll();
    }

    /**
     * データベースからチームIDに一致する選手の一覧を取得する
     * 
     * @return
     */
    public List<Fielder> findTeamMenber(int teamId) {

        List<Fielder> member = new ArrayList<>();
        for (Fielder fielder : repository.findAll()) {
            if (teamId == fielder.getTeamId()) {
                member.add(fielder);
            }
        }
        return member;
    }

    /**
     * データベースにデータを登録する
     * 
     * @return
     */

    public void insert(FielderForm baseBallForm) {
        // データベースに登録する値を保持するインスタンス
        Fielder fielder = new Fielder();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        fielder.setUniformNumber(baseBallForm.getUniformNumber());
        fielder.setName(baseBallForm.getName());
        fielder.setTeamId(baseBallForm.getTeamId());
        fielder.setOrderNum(baseBallForm.getOrderNum());
        fielder.setPosition(baseBallForm.getPosition());
        fielder.setBattingAverage(baseBallForm.getBattingAverage());
        fielder.setHit(baseBallForm.getHit());
        fielder.setDoubleHit(baseBallForm.getDoubleHit());
        fielder.setThreeHit(baseBallForm.getThreeHit());
        fielder.setHomerun(baseBallForm.getHomerun());
        fielder.setRunBattedIn(baseBallForm.getRunBattedIn());
        fielder.setBaseStealing(baseBallForm.getBaseStealing());

        // データベースに登録する
        repository.save(fielder);
    }

    // 野手を削除する
    public void delete(Integer id) {

        // idを指定して、データベースからデータを削除する
        repository.deleteById(id);
    }

    // 受け取ったidからデータを取得して、Formを返却する
    public EditFielderForm getOneFielder(Integer id) {

        // idを指定して本の情報を取得する
        Fielder fielder = repository.findById(id).get();

        // 画面返却用のFormに値を設定する
        EditFielderForm editFielder = new EditFielderForm();
        editFielder.setPlayerId(id);
        editFielder.setUniformNumber(fielder.getUniformNumber());
        editFielder.setName(fielder.getName());
        editFielder.setTeamId(fielder.getTeamId());
        editFielder.setOrderNum(fielder.getOrderNum());
        editFielder.setPosition(fielder.getPosition());
        editFielder.setBattingAverage(fielder.getBattingAverage());
        editFielder.setHit(fielder.getHit());
        editFielder.setDoubleHit(fielder.getDoubleHit());
        editFielder.setThreeHit(fielder.getThreeHit());
        editFielder.setHomerun(fielder.getHomerun());
        editFielder.setRunBattedIn(fielder.getRunBattedIn());
        editFielder.setBaseStealing(fielder.getBaseStealing());

        return editFielder;
    }

    public void update(EditFielderForm editfFielder) {
        // データベースに登録する値を保持するインスタンス
        Fielder fielder = new Fielder();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        fielder.setPlayerId(editfFielder.getPlayerId());
        fielder.setUniformNumber(editfFielder.getUniformNumber());
        fielder.setName(editfFielder.getName());
        fielder.setTeamId(editfFielder.getTeamId());
        fielder.setOrderNum(editfFielder.getOrderNum());
        fielder.setPosition(editfFielder.getPosition());
        fielder.setBattingAverage(editfFielder.getBattingAverage());
        fielder.setHit(editfFielder.getHit());
        fielder.setDoubleHit(editfFielder.getDoubleHit());
        fielder.setThreeHit(editfFielder.getThreeHit());
        fielder.setHomerun(editfFielder.getHomerun());
        fielder.setRunBattedIn(editfFielder.getRunBattedIn());
        fielder.setBaseStealing(editfFielder.getBaseStealing());

        // データベースに登録する
        repository.save(fielder);
    }

}
