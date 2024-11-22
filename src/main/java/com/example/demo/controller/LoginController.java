package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserInfo;

@RestController
public class LoginController {
	
	@GetMapping("/さくらいからもらってくる")
    public UserInfo Registero(@RequestBody UserInfo userInfo) {
		
		//登録処理の呼び出し
        
		UserInfo ReturnUserInfo1 = new UserInfo();
		
		
		//登録判定のbean設定。
		
        return ReturnUserInfo1;  // JSON形式で返される
    }
}
