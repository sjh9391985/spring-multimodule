package dev.be.async.controller;

import dev.be.async.service.AsyncService;
import dev.be.async.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;
    @GetMapping("/get")
    public String getController() {
        demoService.get();
        return "get";
    }



}
