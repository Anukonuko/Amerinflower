package com.example.demo;

public class User {
  private String name;
  private int age;

  // コンストラクタ
  public User(String in_name, int in_age) {
    this.name = in_name;
    this.age  = in_age;
  }

  // ゲッター
  public String getName() {
    return this.name;
  }

  public int GetAge() {
    return this.age;
  }

  public void setName(String in_name) {
    this.name = in_name;
  }

  public void setAge(int in_age) {
    this.age = in_age;
  }
}
