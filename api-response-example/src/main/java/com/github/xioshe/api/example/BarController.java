package com.github.xioshe.api.example;

import com.github.xioshe.api.response.exception.AutoWrappedException;
import com.github.xioshe.api.response.model.Result;
import com.github.xioshe.api.response.model.ResultCode;
import com.github.xioshe.api.response.wrapped.WrappedResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/bar")
public class BarController {

    @GetMapping
    @WrappedResponse
    public Map<String, Object> get() {
        return Map.of("key", "value");
    }

    @GetMapping("/now")
    public Map<String, LocalDateTime> now() {
        return Map.of("now", LocalDateTime.now());
    }

    @GetMapping("/biz")
    public Result biz() {
        return Result.success(Map.of("time", new Date()));
    }

    @GetMapping("/oops")
    public Map<String, Object> oops() {
        throw new AutoWrappedException(ResultCode.USER_NOT_EXIST);
    }
}
