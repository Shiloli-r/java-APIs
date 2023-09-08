package com.validatepolicy.ValidatePolicy.service;

import com.validatepolicy.ValidatePolicy.model.Policy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PolicyService {

    public List<Policy> policyList;

    public PolicyService(){
        policyList = new ArrayList<>();

        Policy policy1 = new Policy("020/EAW/000477", "990800056", "ERASTUSMUIRURI KABUGUA", "020/EAW/000477", "07");
        Policy policy2 = new Policy("020/EAW/000480", "990800049", "JOHN DOE", "020/EAW/000480", "07");

        policyList.addAll(Arrays.asList(policy1, policy2));
    }
}
