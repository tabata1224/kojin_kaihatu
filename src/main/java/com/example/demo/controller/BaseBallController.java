package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.FielderForm;
import com.example.demo.form.PitcherForm;
import com.example.demo.model.Fielder;
import com.example.demo.model.Pitcher;
import com.example.demo.repository.BaseBallRepository;
import com.example.demo.repository.FielderBaseBallRepository;
import com.example.demo.repository.PitcherBaseBallRepository;
import com.example.demo.service.FielderService;
import com.example.demo.service.PitcherService;

@Controller
public class BaseBallController {
    @Autowired
    BaseBallRepository repository;
    @Autowired
    FielderBaseBallRepository fielderBaseBallRepository;
    @Autowired
    PitcherBaseBallRepository pitcherBaseBallRepository;
    @Autowired
    FielderService fielderService;
    @Autowired
    PitcherService pitcherService;

    @GetMapping("/BaseBall")
    public String show(Model model) {
        model.addAttribute("teams", repository.findAll());
        return "baseball";
    }

    @GetMapping(path = "/fielder")
    public String showFielder(@RequestParam("num") int num, Model model) {
        List<Fielder> member = new ArrayList<>();
        for (Fielder fielder : fielderBaseBallRepository.findAll()) {
            if (num == fielder.getTeamId()) {
                member.add(fielder);
            }
        }
        model.addAttribute("hansin", member);
        return "fielder";
    }

    @GetMapping(path = "/pitcher")
    public String showPitcher(@RequestParam("num") int num, Model model) {
        List<Pitcher> member = new ArrayList<>();
        for (Pitcher pitcher : pitcherBaseBallRepository.findAll()) {
            if (num == pitcher.getTeamId()) {
                member.add(pitcher);
            }
        }
        model.addAttribute("hansin", member);

        return "pitcher";
    }

    /**
     * 新規登録画面を表示
     * 
     * @param model
     * @return 新規登録画面
     */

    @GetMapping("/fielder-create")
    public String createFielder(Model model) {

        model.addAttribute("fielderForm", new FielderForm());

        return "addBatter";
    }

    /**
     * fielderデータベースにを登録する
     * 
     * @param fielderForm
     * @param model
     * @return
     */
    @PostMapping("/fielder-create")
    public String saveFielder(@ModelAttribute FielderForm fielderForm, Model model) {

        // fielderを登録する
        fielderService.insert(fielderForm);
        model.addAttribute("teams", repository.findAll());
        // fielderの一覧表示画面にリダイレクト
        return "/baseball";
    }

    /**
     * 新規登録画面を表示
     * 
     * @param model
     * @return 新規登録画面
     */

    @GetMapping("/pitcher-create")
    public String createPitcher(Model model) {

        model.addAttribute("pitcherForm", new PitcherForm());

        return "addPitcher";
    }

    /**
     * fielderデータベースにを登録する
     * 
     * @param pitcherForm
     * @param model
     * @return
     */
    @PostMapping("/pitcher-create")
    public String savePitcher(@ModelAttribute PitcherForm pitcherForm, Model model) {

        // pitcherを登録する
        pitcherService.insert(pitcherForm);
        model.addAttribute("teams", repository.findAll());
        // pitcherの一覧表示画面にリダイレクト
        return "/baseball";
    }

    // 野手の削除を行う
    @GetMapping("/fielder-delete")
    public String deleteFielder(@RequestParam("id") int id, Model model) {

        // データベースのデータを削除する
        fielderService.delete(id);
        model.addAttribute("teams", repository.findAll());

        // チームの一覧画面にリダイレクト
        return "/baseball";
    }

    // 野手の削除を行う
    @GetMapping("/pitcher-delete")
    public String deletePitcher(@RequestParam("id") int id, Model model) {

        // データベースのデータを削除する
        pitcherService.delete(id);
        model.addAttribute("teams", repository.findAll());

        // チームの一覧画面にリダイレクト
        return "/baseball";
    }
}
