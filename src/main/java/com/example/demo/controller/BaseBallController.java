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
import com.example.demo.repository.CLFielderRepository;
import com.example.demo.repository.CLPitcherRepository;
import com.example.demo.repository.FielderRepository;
import com.example.demo.repository.PitcherRepository;

import com.example.demo.service.FielderService;
import com.example.demo.service.PitcherService;

@Controller
public class BaseBallController {
    @Autowired
    BaseBallRepository repository;
    @Autowired
    FielderRepository fielderBaseBallRepository;
    @Autowired
    PitcherRepository pitcherBaseBallRepository;
    @Autowired
    CLFielderRepository clFielderRepository;
    @Autowired
    CLPitcherRepository clPitcherRepository;

    @Autowired
    FielderService fielderService;
    @Autowired
    PitcherService pitcherService;

    private Integer flagAllTeam = 1;

    // メイン画面を表示
    @GetMapping("/BaseBall")
    public String show(Model model) {

        model.addAttribute("teams", repository.findAll());

        return "baseball";
    }

    // 野手一覧の表示
    @GetMapping(path = "/fielder")
    public String showFielder(@RequestParam("num") int teamId, Model model) {

        if (teamId == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByUniformNumberAsc());
            this.flagAllTeam = 0;
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByUniformNumberAsc(teamId));
            this.flagAllTeam = 1;
        }
        return "fielder";
    }

    // 投手一覧の表示
    @GetMapping(path = "/pitcher")
    public String showPitcher(@RequestParam("num") int teamId, Model model) {
        if (teamId == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderByUniformNumberAsc());
            this.flagAllTeam = 0;
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderByUniformNumberAsc(teamId));
            this.flagAllTeam = 1;
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
        model.addAttribute("members",
                fielderBaseBallRepository.findByTeamIdOrderByUniformNumberAsc(fielderForm.getTeamId()));
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
        model.addAttribute("members",
                pitcherBaseBallRepository.findByTeamIdOrderByUniformNumberAsc(pitcherForm.getTeamId()));
        // pitcherの一覧表示画面にリダイレクト
        return "pitcher";
    }

    // 野手の削除を行う
    @GetMapping("/fielder-delete")
    public String deleteFielder(@RequestParam("id") int id, Model model) {
        int teamId = fielderBaseBallRepository.findById(id).orElseThrow().getTeamId();

        // データベースのデータを削除する
        fielderService.delete(id);
        model.addAttribute("members",
                fielderBaseBallRepository.findByTeamIdOrderByUniformNumberAsc(teamId));
        // fielderの一覧表示画面にリダイレクト
        return "fielder";
    }

    // 投手の削除を行う
    @GetMapping("/pitcher-delete")
    public String deletePitcher(@RequestParam("id") int id, Model model) {
        int teamId = pitcherBaseBallRepository.findById(id).orElseThrow().getTeamId();

        // データベースのデータを削除する
        pitcherService.delete(id);

        model.addAttribute("members",
                pitcherBaseBallRepository.findByTeamIdOrderByUniformNumberAsc(teamId));

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
        // fielderを登録する
        fielderService.update(editFielderForm);

        model.addAttribute("members",
                fielderBaseBallRepository.findByTeamIdOrderByUniformNumberAsc(editFielderForm.getTeamId()));
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
        editPitcher = pitcherService.getOnePitcher(id);
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
        // pitcherを登録する
        pitcherService.update(editPitcherForm);

        model.addAttribute("members",
                pitcherBaseBallRepository.findByTeamIdOrderByUniformNumberAsc(editPitcherForm.getTeamId()));

        // pitcherの一覧表示画面にリダイレクト
        return "pitcher";
    }

    // 野手の並び替え機能(打順)
    @GetMapping(path = "/fielder-sortOrder")
    public String fielderSortOrder(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByOrderNumAsc());
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByOrderNumAsc(teamId));
        }
        return "fielder";
    }

    // 野手の並び替え機能(打率)
    @GetMapping(path = "/fielder-sortBattingAverage")
    public String fielderSortAattingAverage(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByBattingAverageDesc());
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByBattingAverageDesc(teamId));
        }
        return "fielder";
    }

    // 野手の並び替え機能(安打数)
    @GetMapping(path = "/fielder-sortHit")
    public String fielderSortHit(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByHitDesc());
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByHitDesc(teamId));
        }
        return "fielder";
    }

    // 野手の並び替え機能(二塁打数)
    @GetMapping(path = "/fielder-sortDoubleHit")
    public String fielderSortDoubleHit(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByDoubleHitDesc());
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByDoubleHitDesc(teamId));
        }
        return "fielder";
    }

    // 野手の並び替え機能(三塁打数)
    @GetMapping(path = "/fielder-sortThreeHit")
    public String fielderSortThreeHit(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByThreeHitDesc());
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByThreeHitDesc(teamId));
        }
        return "fielder";
    }

    // 野手の並び替え機能(本塁打数)
    @GetMapping(path = "/fielder-sortHomerun")
    public String fielderSortHomerun(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByHomerunDesc());
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByHomerunDesc(teamId));
        }
        return "fielder";
    }

    // 野手の並び替え機能(打点)
    @GetMapping(path = "/fielder-sortRunBattedIn")
    public String fielderSortRunBattedIn(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByRunBattedInDesc());
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByRunBattedInDesc(teamId));
        }
        return "fielder";
    }

    // 野手の並び替え機能(盗塁)
    @GetMapping(path = "/fielder-sortBaseStealing")
    public String fielderSortBaseStealingIn(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", fielderBaseBallRepository.findAllByOrderByBaseStealingDesc());
        } else {
            model.addAttribute("members", fielderBaseBallRepository.findByTeamIdOrderByBaseStealingDesc(teamId));
        }
        return "fielder";
    }

    // 投手の並び替え機能(登板数)
    @GetMapping(path = "/pitcher-sortPitched")
    public String pitcherSortPitched(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderByPitchedDesc());
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderByPitchedDesc(teamId));
        }
        return "pitcher";
    }

    // 投手の並び替え機能(防御率)
    @GetMapping(path = "/pitcher-sortEarnedRunsAverage")
    public String pitcherSortEarnedRunsAverage(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderByEarnedRunsAverageAsc());
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderByEarnedRunsAverageAsc(teamId));
        }
        return "pitcher";
    }

    // 投手の並び替え機能(勝ち)
    @GetMapping(path = "/pitcher-sortWin")
    public String pitcherSortWin(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderByWinDesc());
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderByWinDesc(teamId));
        }
        return "pitcher";
    }

    // 投手の並び替え機能(負け)
    @GetMapping(path = "/pitcher-sortLose")
    public String pitcherSortLose(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderByLoseDesc());
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderByLoseDesc(teamId));
        }
        return "pitcher";
    }

    // 投手の並び替え機能(セーブ)
    @GetMapping(path = "/pitcher-sortSave")
    public String pitcherSortSave(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderBySaveDesc());
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderBySaveDesc(teamId));
        }
        return "pitcher";
    }

    // 投手の並び替え機能(ホールド)
    @GetMapping(path = "/pitcher-sortHold")
    public String pitcherSortHold(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderByHoldDesc());
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderByHoldDesc(teamId));
        }
        return "pitcher";
    }

    // 投手の並び替え機能(投球回)
    @GetMapping(path = "/pitcher-sortInningsPitched")
    public String pitcherSortInningsPitched(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderByInningsPitchedDesc());
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderByInningsPitchedDesc(teamId));
        }
        return "pitcher";
    }

    // 投手の並び替え機能(奪三振)
    @GetMapping(path = "/pitcher-sortStrikeOut")
    public String pitcherSortStrikeOutDesc(@RequestParam("teamId") int teamId, Model model) {

        if (this.flagAllTeam == 0) {
            model.addAttribute("members", pitcherBaseBallRepository.findAllByOrderByStrikeOutDesc());
        } else {
            model.addAttribute("members", pitcherBaseBallRepository.findByTeamIdOrderByStrikeOutDesc(teamId));
        }
        return "pitcher";
    }

    // CLメンバーを表示
    @GetMapping(path = "/CLMember")
    public String showCLMember(Model model) {
        model.addAttribute("members", clFielderRepository.findAllByOrderByOrderNumAsc());
        model.addAttribute("pitcher", clPitcherRepository.findAllByOrderByUniformNumberAsc());
        return "clMember";
    }

    /**
     * CL野手更新画面を表示
     * 
     * @param model
     * @return 更新画面
     */

    @GetMapping("/clFielder-edit")
    public String editCLFielder(@RequestParam("id") int id, Model model, EditFielderForm editFielder) {
        editFielder = fielderService.getCLOneFielder(id);
        model.addAttribute("editFielderForm", editFielder);

        return "editCLFielder";
    }

    /**
     * CLfielderデータベースにを登録する
     * 
     * @param editFielderForm
     * @param model
     * @return
     */
    @PostMapping("/clFielder-edit")
    public String saveCLEditFielder(@ModelAttribute @Validated EditFielderForm editFielderForm, BindingResult result,
            Model model) {
        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 新規登録画面に遷移
            return "editCLFielder";
        }
        // fielderを登録する
        fielderService.CLUpdate(editFielderForm);

        model.addAttribute("members", clFielderRepository.findAllByOrderByOrderNumAsc());
        model.addAttribute("pitcher", clPitcherRepository.findAllByOrderByUniformNumberAsc());
        // fielderの一覧表示画面にリダイレクト
        return "clMember";
    }

    /**
     * CL投手更新画面を表示
     * 
     * @param model
     * @return 更新画面
     */

    @GetMapping("/clPitcher-edit")
    public String editCLPitcher(@RequestParam("id") int id, Model model, EditPitcherForm editPitcher) {
        editPitcher = pitcherService.getCLOnePitcher(id);
        model.addAttribute("editPitcherForm", editPitcher);
        return "editCLPitcher";
    }

    /**
     * pitcherデータベースにを登録する
     * 
     * @param editPitcherForm
     * @param
     * 
     */
    @PostMapping("/clPitcher-edit")
    public String saveCLEditPitcher(@ModelAttribute @Validated EditPitcherForm editPitcherForm, BindingResult result,
            Model model) {
        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 新規登録画面に遷移
            return "editCLPitcher";
        }
        // pitcherを登録する
        pitcherService.clUpdate(editPitcherForm);

        model.addAttribute("members", clFielderRepository.findAllByOrderByOrderNumAsc());
        model.addAttribute("pitcher", clPitcherRepository.findAllByOrderByUniformNumberAsc());

        // pitcherの一覧表示画面にリダイレクト
        return "clMember";
    }
}