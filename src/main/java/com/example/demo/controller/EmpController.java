package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmpSampleRepository;

@Controller
public class EmpController {

    @Autowired
    EmpSampleRepository empRepository;

    @Autowired
    DepartmentRepository depRepository;

    // 社員一覧表示処理
    @GetMapping("/showView")
    public String showView(Model model, HttpSession session) {

        // 部署テーブルから全レコードを取得、セッションスコープに保存
        session.setAttribute("deps", depRepository.findAll());
        // 内部結合した社員情報の全レコード取得、リクエストスコープに保存
        model.addAttribute("emps", empRepository.findAll());
        return "view";
    }

    // 検索処理
    @GetMapping("/doSearchByDep")
    public String doSearchByDep(Model model, Integer depId) {

        // フォームで選択された部署のidで初期化
        Department dep = new Department();
        dep.setId(depId);
        model.addAttribute("emps", empRepository.findByDepartment(dep));

        return "view";
    }
}
