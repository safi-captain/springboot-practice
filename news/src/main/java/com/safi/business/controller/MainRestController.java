package com.safi.business.controller;

/**
 * Created by xiefeng
 * Time 2018/9/21
 */

import com.safi.business.service.UserService;
import com.safi.utils.JsonData;
import com.safi.utils.RedisUtil;
import com.safi.utils.annotation.SqlLog;
import com.safi.utils.exception.FirstException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 主controller，app入口
 */
@RestController
@RequestMapping("study")
public class MainRestController {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    @SqlLog(desc = "初始化")
    @RequestMapping("init")
    public JsonData init() {
        String data = "safi";
        redisUtil.set(data, "safi", 1000);
        String result = (String) redisUtil.get(data);
        int count = userService.countUser();

        return JsonData.getSucceed("hello world~! " + result + ", total " + count);
    }

    @RequestMapping("test")
    public JsonData test() {
        int count = userService.countUser();
        if (count == 2) {
            throw new FirstException("人数不对");
        }
        return JsonData.getSucceed("成功");
    }

    @RequestMapping("test-file")
    public JsonData testFile() throws FileNotFoundException {
        File file = new File("abc.txt");

        InputStream inputStream = new FileInputStream(file);
//        try {
//            InputStream inputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            throw new FirstException(e.getMessage());
//        }
        return JsonData.getSucceed("成功");
    }

    @RequestMapping("test-two")
    public JsonData testTwo() {
        testTwoOne();
        return JsonData.getSucceed("成功");
    }

    private void testTwoOne() {
        throw new FirstException("测试隔方法exception");
    }

    @RequestMapping("test-three")
    public JsonData testThree() {
        List<String> temp = new ArrayList<>();

        temp.get(0);

        return JsonData.getSucceed("成功");
    }
}
