package com.validatepolicy.ValidatePolicy.controller;

import com.validatepolicy.ValidatePolicy.model.Authentication;
import com.validatepolicy.ValidatePolicy.response.ErrorDesc;
import com.validatepolicy.ValidatePolicy.request.RequestPayload;
import com.validatepolicy.ValidatePolicy.response.ResponsePayload;
import com.validatepolicy.ValidatePolicy.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path="api/Solid/SubmitRequest")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponsePayload> processRequest(@RequestBody RequestPayload requestPayload) {
        ResponsePayload response = new ResponsePayload();

        // Validate the API user and password

        for (Authentication authentication: authenticationService.authList) {
            if(Objects.equals(authentication.getApi_user(), requestPayload.getMessageValidation().getApiUser()) && Objects.equals(authentication.getApi_password(), requestPayload.getMessageValidation().getApiPassword())) {
                // TODO: Check interface

                // Create the response payload
                final String token = authenticationService.generateToken();
                final String expiry = authenticationService.generateTimeStamp();
                response.setError_code("00");

                ErrorDesc errorDesc = new ErrorDesc();
                errorDesc.setToken(token);
                errorDesc.setExpiry(expiry);

                response.setError_desc(errorDesc);

            }
            else{
                // create the response payload
                response.setError_code("01");
                // TODO: Set Error Desc to "Invalid API consumer"
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
