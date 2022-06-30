package com.example.practice.controller;

import com.example.practice.registration.registration.RegistrationRequest;
import com.example.practice.registration.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
