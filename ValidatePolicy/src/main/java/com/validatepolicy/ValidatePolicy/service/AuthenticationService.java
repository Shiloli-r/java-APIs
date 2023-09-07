package com.validatepolicy.ValidatePolicy.service;

import com.validatepolicy.ValidatePolicy.model.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class AuthenticationService {
    private List<Authentication> authList;

    public AuthenticationService(){
        authList = new ArrayList<>();

        Authentication auth1 = new Authentication("icealiontest","123456");
        Authentication auth2 = new Authentication("test", "123456");

        authList.addAll(Arrays.asList(auth1, auth2));
    }

    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    public String generateTimeStamp(){
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return format.format(timestamp);
    }
}
