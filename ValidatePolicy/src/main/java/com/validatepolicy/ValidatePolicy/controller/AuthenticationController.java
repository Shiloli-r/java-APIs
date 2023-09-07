package com.validatepolicy.ValidatePolicy.controller;

import com.validatepolicy.ValidatePolicy.model.Authentication;
import com.validatepolicy.ValidatePolicy.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/Solid/SubmitRequest")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public String generateToken(@RequestBody Authentication authentication){
       final String token = authenticationService.generateToken();
       final String expiry = authenticationService.generateTimeStamp();

       return "{\n" +
               "\"error_code\": \"00\",\n" +
               "\"error_desc\": {\n" +
               "\"token\": \"" + token + "\",\n" +
               "\"expiry\": \"" + expiry +"\"\n" +
               "}\n" +
               "}";

    }

}
