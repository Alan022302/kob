package com.kob.backend.controller.user.account.qq;

import com.alibaba.fastjson.JSONObject;
import com.kob.backend.service.user.account.qq.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WebController {
    @Autowired
    private WebService webService;

    @GetMapping("/api/user/account/qq/apply_code/")
    JSONObject applyCode(){
        return webService.applyCode();
    }

    @GetMapping("/api/user/account/qq/receive_code")
    public JSONObject receiveCode(@RequestParam Map<String, String> data){
        String code = data.get("code");
        String state = data.get("state");
        return webService.receiveCode(code, state);
    }
}
