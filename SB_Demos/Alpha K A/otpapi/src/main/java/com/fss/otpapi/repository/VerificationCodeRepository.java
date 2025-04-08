package com.fss.otpapi.repository;

import com.fss.otpapi.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    @Query("SELECT u FROM VerificationCode u WHERE u.email = :email ORDER BY u.expiryTime DESC LIMIT 1")
    VerificationCode findByEmail(String email);
}
