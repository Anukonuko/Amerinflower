package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")  // テーブル名を明示的に指定（デフォルトではクラス名がテーブル名になります）
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDはAUTO_INCREMENT
    private Long id;

    private String name;  // ユーザー名

    @Column(unique = true)  // メールアドレスは一意
    private String email;  // メールアドレス

    private String password;  // パスワード（ハッシュ化されたもの）

    @Column(name = "created_at", updatable = false)  // created_at は初期値がセットされ、更新しない
    private LocalDateTime createdAt;  // アカウント作成日時

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;  // 更新日時

    @Enumerated(EnumType.STRING)  // ENUM 型の列挙型を使う
    private AccountStatus status = AccountStatus.ACTIVE;  // アカウントの状態

    @Column(name = "last_login")
    private LocalDateTime lastLogin;  // 最終ログイン日時

    // Enum: アカウントの状態
    public enum AccountStatus {
        ACTIVE, SUSPENDED, DELETED, PENDING
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    // Optional: @PrePersist, @PreUpdateを使ってcreatedAt, updatedAtを自動設定する方法もあります。
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}