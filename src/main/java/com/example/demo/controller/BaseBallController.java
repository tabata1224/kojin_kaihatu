package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.EditFielderForm;
import com.example.demo.form.EditPitcherForm;
import com.example.demo.form.FielderForm;
import com.example.demo.form.PitcherForm;
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

    private Integer menberId;

    @GetMapping("/BaseBall")
    public String show(Model model) {

        model.addAttribute("teams", repository.findAll());

        return "baseball";
    }

    @GetMapping(path = "/fielder")
    public String showFielder(@RequestParam("num") int teamId, Model model) {

        if (teamId == 0) {
            model.addAttribute("hansin", fielderBaseBallRepository.findAll());
        } else {
            model.addAttribute("hansin", fielderService.findTeamMenber(teamId));
        }
        return "fielder";
    }

    @GetMapping(path = "/pitcher")
    public String showPitcher(@RequestParam("num") int teamId, Model model) {
        if (teamId == 0) {
            model.addAttribute("hansin", pitcherBaseBallRepository.findAll());
        } else {
            model.addAttribute("hansin", pitcherService.findTeamMenber(teamId));
        }
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

        return "addFielder";
    }

    /**
     * fielderデータベースにを登録する
     * 
     * @param fielderForm
     * @param model
     * @return
     */
    @PostMapping("/fielder-create")
    public String saveFielder(@ModelAttribute @Validated FielderForm fielderForm, BindingResult result, Model model) {

        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 新規登録画面に遷移
            return "addFielder";
        }

        // fielderを登録する
        fielderService.insert(fielderForm);
        model.addAttribute("hansin", fielderService.findTeamMenber(fielderForm.getTeamId()));
        // fielderの一覧表示画面にリダイレクト
        return "fielder";
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
     * pitcherデータベースにを登録する
     * 
     * @param pitcherForm
     * @param model
     * @return
     */
    @PostMapping("/pitcher-create")
    public String savePitcher(@ModelAttribute @Validated PitcherForm pitcherForm, BindingResult result, Model model) {
        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 新規登録画面に遷移
            return "addPitcher";
        }
        // pitcherを登録する
        pitcherService.insert(pitcherForm);
        model.addAttribute("hansin", pitcherService.findTeamMenber(pitcherForm.getTeamId()));
        // pitcherの一覧表示画面にリダイレクト
        return "pitcher";
    }

    // 野手の削除を行う
    @GetMapping("/fielder-delete")
    public String deleteFielder(@RequestParam("id") int id, Model model) {
        int teamId = fielderBaseBallRepository.findById(id).get().getTeamId();

        // データベースのデータを削除する
        fielderService.delete(id);
        model.addAttribute("hansin", fielderService.findTeamMenber(teamId));
        // fielderの一覧表示画面にリダイレクト
        return "fielder";
    }

    // 投手の削除を行う
    @GetMapping("/pitcher-delete")
    public String deletePitcher(@RequestParam("id") int id, Model model) {
        int teamId = pitcherBaseBallRepository.findById(id).get().getTeamId();

        // データベースのデータを削除する
        pitcherService.delete(id);
        model.addAttribute("hansin", pitcherService.findTeamMenber(teamId));

        // fielderの一覧画面にリダイレクト
        return "pitcher";
    }

    /**
     * 野手更新画面を表示
     * 
     * @param model
     * @return 更新画面
     */

    @GetMapping("/fielder-edit")
    public String editFielder(@RequestParam("id") int id, Model model, EditFielderForm editFielder) {
        editFielder = fielderService.getOneFielder(id);
        menberId = id;
        model.addAttribute("editFielderForm", editFielder);

        return "editFielder";
    }

    /**
     * fielderデータベースにを登録する
     * 
     * @param editFielderForm
     * @param model
     * @return
     */
    @PostMapping("/fielder-edit")
    public String saveEditFielder(@ModelAttribute @Validated EditFielderForm editFielderForm, BindingResult result,
            Model model) {
        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 新規登録画面に遷移
            return "editFielder";
        }
        editFielderForm.setPlayerId(menberId);
        // fielderを登録する
        fielderService.update(editFielderForm);
        model.addAttribute("hansin", fielderService.findTeamMenber(editFielderForm.getTeamId()));
        // fielderの一覧表示画面にリダイレクト
        return "fielder";
    }

    /**
     * 投手更新画面を表示
     * 
     * @param model
     * @return 更新画面
     */

    @GetMapping("/pitcher-edit")
    public String editPitcher(@RequestParam("id") int id, Model model, EditPitcherForm editPitcher) {
        editPitcher = pitcherService.getOneFielder(id);
        menberId = id;
        model.addAttribute("editPitcherForm", editPitcher);
        return "editPitcher";
    }

    /**
     * pitcherデータベースにを登録する
     * 
     * @param editPitcherForm
     * @param
     * 
     */
    @PostMapping("/pitcher-edit")
    public String saveEditPitcher(@ModelAttribute @Validated EditPitcherForm editPitcherForm, BindingResult result,
            Model model) {
        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 新規登録画面に遷移
            return "editPitcher";
        }
        editPitcherForm.setPlayerId(menberId);
        // pitcherを登録する
        pitcherService.update(editPitcherForm);

        model.addAttribute("hansin", pitcherService.findTeamMenber(editPitcherForm.getTeamId()));
        // pitcherの一覧表示画面にリダイレクト
        return "pitcher";
    }
}