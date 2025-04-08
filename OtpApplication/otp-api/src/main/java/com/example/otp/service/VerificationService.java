package com.example.otp.service;

import com.example.otp.model.VerificationCode;
import com.example.otp.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class VerificationService {

    @Autowired
    private VerificationCodeRepository repository;

    @Autowired
    private EmailService emailService;

    // Generate and send OTP
    public String sendOtp(String email) {
        String otp = String.format("%06d", new Random().nextInt(999999));
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(5);

        VerificationCode verificationCode = new VerificationCode(email, otp, expiryTime);
        repository.save(verificationCode);

       // emailService.sendOtpEmail(email, otp);
        return "OTP sent successfully!";
    }

    // Verify OTP
    public String verifyOtp(String email, String code) {
        Optional<VerificationCode> storedCode = repository.findByEmail(email);

        if (storedCode.isPresent()) {
            VerificationCode verificationCode = storedCode.get();

            if (verificationCode.getCode().equals(code) && verificationCode.getExpiryTime().isAfter(LocalDateTime.now())) {
                return "OTP verification successful!";
            }
        }
        return "Invalid or expired OTP.";
    }
}
