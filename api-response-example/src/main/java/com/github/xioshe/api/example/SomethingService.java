package com.github.xioshe.api.example;

import org.springframework.stereotype.Service;

@Service
public class SomethingService {

    public String mayThrowException(String args) {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("args cannot be empty");
        }
        return "I did something";
    }
}
