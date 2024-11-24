package com.example.demo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserRegister;

import jakarta.validation.Valid;


@RestController

public class RegisterController {
	
	/**
	 * 入力画面から受け渡された値のバリデーションチェックを実施する。
	 * 	
	 * 
	 * @param userInfo
	 * @return 
	 */
	@GetMapping("/api/user")
    public String UserInfoConfirm(@RequestBody @Valid UserInfo userInfo,BindingResult bindingResult) {
		
		//バリデーションチェック
		if (bindingResult.hasErrors()) {
		    // バリデーションエラーがある場合の処理
		    return "input";  // エラーがあれば入力画面に戻る
		}
		//エラーがない場合は確認画面に遷移。
		return "comfirm";
        
    }
	
	/**
	 * 
	 * @param userInfo
	 * @return
	 */
	@GetMapping("/api/user")
    public UserInfo UserInfoRegister(@RequestBody UserInfo userInfo) {
		
		//登録処理の呼び出し
        
		UserInfo ReturnUserInfo = new UserInfo();
		
		//これ、よくないわ...。ひかるにメルアド投げてもらうようにしよ
		
		UserRegister userRegister = new UserRegister();
		userRegister.RegisterIppanUser(ReturnUserInfo.getName(), ReturnUserInfo.getEmail());
		
		
		//登録判定のbean設定。
		
        return ReturnUserInfo;  // JSON形式で返される...？なにが??
        
    }
	
	
	
	
	
}

