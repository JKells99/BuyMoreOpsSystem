package com.buymore.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    @Autowired
    private UserRestRepo userRestRepo;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginCreds loginCreds) {
        try {
            User user = userRestRepo.findByUserName((loginCreds.getUserName()));
            if (user != null && BCrypt.checkpw(loginCreds.getPassword(), user.getPassword())) {
                return ResponseEntity.ok("Login successful for user: " + user.getUserName());
            } else {
                return ResponseEntity.status(401).body("Invalid email or password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while processing your request: " + e.getMessage());
        }

    }
}
