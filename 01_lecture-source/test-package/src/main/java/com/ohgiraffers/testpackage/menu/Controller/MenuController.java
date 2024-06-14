package com.ohgiraffers.testpackage.menu.Controller;

import com.ohgiraffers.testpackage.menu.model.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/main")
public class MenuController {

    public final MenuService service;

    @Autowired
    public MenuController(MenuService service){
        this.service =service;
    }

    @GetMapping("/regist")
    public void registPage(){}



}
