package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserInfo {
	
	public UserInfo(){
	}
	
	@NotEmpty(message = "名前は必須です")
	private String name;
	
	@NotEmpty(message = "年齢は必須です")
	private int age;
	
	@NotEmpty(message = "メールアドレスは必須です")
	@Email(message = "有効なメールアドレスを入力してください")
	private String email;
	
	
	@NotEmpty(message = "パスワードを入力してくさだい")
    @Size(min = 8, max = 16, message = "パスワードは8文字以上16文字以内で入力してください")
    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])", 
             message = "パスワードには、大文字、小文字、数字、特殊文字（例: !@#$%^&*）を含めてください")
	private String passWord;
	
    @NotEmpty
    //これはあとあとカスタムバリデーションで実施したい
    private String confirmPassword;
	
	//いずれ住所を記載したい
	//そのときにはDBも買えないとだから面倒ね。
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
