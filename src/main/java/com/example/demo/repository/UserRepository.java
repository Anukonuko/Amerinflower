package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserTable;


@Service
public interface UserRepository extends JpaRepository<UserTable, Long> {
    // 必要なクエリメソッドを追加
	

}		