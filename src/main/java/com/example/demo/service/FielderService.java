package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
