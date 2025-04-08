package com.example.otp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vctab")
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String code;
    private LocalDateTime expiryTime;

    public VerificationCode() {}

    public VerificationCode(String email, String code, LocalDateTime expiryTime) {
        this.email = email;
        this.code = code;
        this.expiryTime = expiryTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    // Getters and Setters
}