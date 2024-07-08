package com.github.xioshe.api.example;

import com.github.xioshe.api.response.model.Result;
import com.github.xioshe.api.response.wrapped.WrappedResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/something")
public class SomethingController {

    private final SomethingService somethingService;

    @GetMapping
    public Result something() {
        try {
            return Result.success(Map.of("word", somethingService.mayThrowException("any args")));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.failure(5000, e.getMessage());
        }
    }

    @WrappedResponse
    @GetMapping("wrapped")
    public Map<String, String> wrapSomething() {
        return Map.of("word", somethingService.mayThrowException("any args"));
    }
}
