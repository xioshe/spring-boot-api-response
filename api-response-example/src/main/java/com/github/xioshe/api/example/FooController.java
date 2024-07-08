package com.github.xioshe.api.example;


import com.github.xioshe.api.response.model.Result;
import com.github.xioshe.api.response.wrapped.WrappedResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@WrappedResponse
@RestController
@RequestMapping("/foo")
public class FooController {


    @GetMapping
    public Map<String, Object> get() {
        return Map.of("key", "value");
    }

    @GetMapping("/biz")
    public Result biz() {
        return Result.success(Map.of("time", new Date()));
    }

    @GetMapping("/oops")
    public Map<String, Object> oops() {
        throw new RuntimeException("oops");
    }

    @PostMapping
    public void post() {
        // do something
    }

}
