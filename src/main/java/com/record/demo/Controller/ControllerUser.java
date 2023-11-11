package com.record.demo.Controller;

import com.record.demo.Services.ServiceDetailsUser;
import com.record.demo.model.Usercars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUser {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ServiceDetailsUser detailsUser;

    @PostMapping("/sign_up")
    public ResponseEntity<Usercars> RegisterUser(@RequestBody Usercars register){
        String encriptarcontra=passwordEncoder.encode(register.getPassword());
        register.setPassword(encriptarcontra);
        detailsUser.RegisterUser(register);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }
}
