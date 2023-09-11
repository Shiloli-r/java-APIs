package com.validatepolicy.ValidatePolicy.controller;

import com.validatepolicy.ValidatePolicy.model.Authentication;
import com.validatepolicy.ValidatePolicy.model.Policy;
import com.validatepolicy.ValidatePolicy.response.ErrorDesc;
import com.validatepolicy.ValidatePolicy.request.RequestPayload;
import com.validatepolicy.ValidatePolicy.response.ResponsePayload;
import com.validatepolicy.ValidatePolicy.service.AuthenticationService;
import com.validatepolicy.ValidatePolicy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path="api/Solid/SubmitRequest")
public class ValidatePolicyController {

    private final AuthenticationService authenticationService;
    private final PolicyService policyService;

    @Autowired
    public ValidatePolicyController(AuthenticationService authenticationService, PolicyService policyService) {
        this.authenticationService = authenticationService;
        this.policyService = policyService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponsePayload> processRequest(@RequestBody RequestPayload requestPayload) {
        ResponsePayload response = new ResponsePayload();

        // check interface --> if TOKEN, then generate token elseif CUSTOMER_INFO, validate policy
        if (Objects.equals(requestPayload.getMessageRoute().getInterfaceName(), "TOKEN")) {
            // Validate the API user and password
            for (Authentication authentication : authenticationService.authList) {
                if (Objects.equals(authentication.getApi_user(), requestPayload.getMessageValidation().getApiUser()) && Objects.equals(authentication.getApi_password(), requestPayload.getMessageValidation().getApiPassword())) {
                    // Create the response payload
                    final String token = authenticationService.generateToken();
                    final String expiry = authenticationService.generateTimeStamp();
                    response.setError_code("00");

                    ErrorDesc errorDesc = new ErrorDesc();
                    errorDesc.setToken(token);
                    errorDesc.setExpiry(expiry);

                    response.setError_desc(errorDesc);
                    break; // exit the for loop

                } else {
                    // create the response payload
                    response.setError_code("01");
                    // TODO: Set Error Desc to "Invalid API consumer"
                }
            }
        } else if (Objects.equals(requestPayload.getMessageRoute().getInterfaceName(), "CUSTOMER_INFO")) {
            for (Policy policy : policyService.policyList){
                if(Objects.equals(policy.getPolicyNo(), requestPayload.getMessageBody().getPolicyNo()) && Objects.equals(policy.getBankCode(), requestPayload.getMessageBody().getBankCode())){
                    // policy number and Bank Code exist
                    response.setError_code("00");

                    ErrorDesc errorDesc = new ErrorDesc();

                    errorDesc.setMessage("VALID");
                    errorDesc.setStatusCode("00");
                    errorDesc.setAccountNo(policy.getAccNo());
                    errorDesc.setCustomerName(policy.getCustomerName());
                    errorDesc.setOutstandingAmount(null);
                    errorDesc.setDueDate(null);

                    response.setError_desc(errorDesc);
                    break;
                } else{
                    response.setError_code("00");
                    ErrorDesc errorDesc = new ErrorDesc();

                    errorDesc.setMessage("INVALID");
                    errorDesc.setReferenceNumber("1349");
                    errorDesc.setCustomerName("");
                    errorDesc.setOutstandingAmount(null);
                    errorDesc.setDueDate(null);
                    errorDesc.setStatusCode("01");

                    response.setError_desc(errorDesc);
                }

            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
