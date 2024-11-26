package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserRegister;

import jakarta.validation.Valid;


@Controller
public class RegisterController {
	
	
	
	@GetMapping("/form")
	private String readForm(@ModelAttribute UserInfo UserInfo) {
		return "form";
	}
	
	
	@GetMapping("/otameshi")
    public String showForm() {
        return "otameshi";  
    }

	
	/**
	 * 入力画面から受け渡された値のバリデーションチェックを実施する。
	 * 	
	 * 
	 * @param userInfo
	 * @return 	
	 */
	@PostMapping("/otameshi")
    public String UserInfoConfirm(@ModelAttribute @Valid UserInfo userInfo,BindingResult bindingResult) {
		
		System.out.println("aaaa");		
		System.out.println(userInfo.getName());
		System.out.println(userInfo.getAge());
		System.out.println(userInfo.getEmail());
		System.out.println(userInfo.getPassWord());
		
		
		//バリデーションチェック
		if (bindingResult.hasErrors()) {
			// エラーがあれば入力画面に戻る
		    return "hello";  
		}
		//エラーがない場合は確認画面に遷移。
		return "hello";
        
    }
	
	/**
	 * 
	 * @param userInfo
	 * @return
	 */
	@PostMapping("/api/user")
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

