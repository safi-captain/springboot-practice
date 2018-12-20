package com.safi.business.controller;

import com.safi.utils.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiefeng
 * Time 2018/12/10
 */
@Controller
@RequestMapping("study-page")
public class MainController {
    @RequestMapping("init")
    public String init() {
        List<String> temp = new ArrayList<>();

        temp.get(0);

        return "index";
    }
}
