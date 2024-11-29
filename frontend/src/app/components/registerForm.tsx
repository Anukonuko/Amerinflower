"use client";
import React, { use } from "react";
import { useState } from "react";
import styles from "../styles/registerForm.module.css";
import Main from "src/app/components/main"

interface User {
  name: string;
  age:  number;
}

export default function registerForm() {
  const [formData, setFormData] = useState<User>({
    name: "",
    age: 0,
  });

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const inputName = event.target.name;
    const inputValue = event.target.value;

    setFormData({
      ...formData,
      [inputName]:
        inputName === "age" && inputValue === ""
          ? ""
          : inputName === "age"
          ? parseInt(inputValue, 10)
          : inputValue,
    });
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    try {
      const response = await fetch("http://localhost:8080/api/user", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        console.log("送信成功!!!");
      } else {
        console.log("送信失敗");
      }
    } catch (error) {
      console.error("通信エラー", error);
    }
  };

  return (
    <>
      <Main>

      <h1 className={styles.userRegisterTitle}>会員登録</h1>
      <div className={styles.registerFormWrapper}>
        <form className={styles.registerForm} onSubmit={handleSubmit}>
          <label>
            氏名
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
              placeholder="氏名"
              />
          </label>
          <label>
            年齢
            <input
              type="text"
              name="age"
              value={formData.age}
              onChange={handleChange}
              required
              placeholder="年齢"
              />
          </label>
          <button type="submit">登録</button>
        </form>
      </div>
    </Main>
    </>
  );
}
