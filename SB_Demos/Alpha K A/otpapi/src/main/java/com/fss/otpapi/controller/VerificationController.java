package com.fss.otpapi.controller;

import com.fss.otpapi.model.VerificationCode;
import com.fss.otpapi.repository.VerificationCodeRepository;
import com.fss.otpapi.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin(origins = "http://localhost:4200")
public class VerificationController {

    @Autowired
    private VerificationCodeRepository vcRepo;

    @Autowired
    private VerificationService verificationService;

    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendOtp(@RequestParam String email) {
        // Logic to send OTP
        Map<String, String> response = new HashMap<>();
        response.put("message", "OTP sent successfully");
        verificationService.sendOtp(email);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify")
    public ResponseEntity<Map<String, String>> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        // Logic to verify OTP
        Map<String, String> response = new HashMap<>();
        boolean isValid = true;

        if (isValid) {
            String result =verificationService.verifyOtp(email, otp);
            response.put("message", result);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid OTP");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<VerificationCode> getOtpDetails() {
        VerificationCode vc= vcRepo.findAll().iterator().next();
        return ResponseEntity.ok(vc);
    }
}
