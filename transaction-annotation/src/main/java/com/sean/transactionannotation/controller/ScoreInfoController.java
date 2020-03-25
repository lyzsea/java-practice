package com.sean.transactionannotation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class ScoreInfoController {

    @ResponseBody
    @RequestMapping(value = "getScoreInfo")
    public String getScoreInfo() {
        return "hello spring boot!";
    }
}
