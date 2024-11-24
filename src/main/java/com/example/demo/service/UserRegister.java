package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserTable;
import com.example.demo.repository.UserRepository;

@Service
public class UserRegister {

	@Autowired
    private UserRepository userRepository;  // リポジトリのインジェクション
	
	public UserTable RegisterIppanUser(String name, String email) {
		//インスタンス化
		UserTable UserTable = new UserTable();
		
		UserTable.setName(name);
		UserTable.setEmail(email);
		
		
		//　ユーザー情報をデータベースに保存
		return userRepository.save(UserTable);
	}
};
