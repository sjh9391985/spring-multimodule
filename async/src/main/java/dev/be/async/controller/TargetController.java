package dev.be.async.controller;

import dev.be.async.common.dto.BaseRequestInfo;
import dev.be.async.common.dto.BaseResponseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target-server")
public class TargetController {

    @GetMapping("/get")
    public BaseResponseInfo demoGet(
                                    @RequestHeader("CustomHeaderName") String header,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Long age
    ) {
        return BaseResponseInfo.builder()
                .header(header)
                .name(name)
                .age(age)
                .build();
    }

    @PostMapping("/post")
    public BaseResponseInfo demoPost(
            @RequestHeader("CustomHeaderName") String header,
            @RequestBody BaseRequestInfo body
            ) {
        return BaseResponseInfo.builder()
                .header(header)
                .name(body.getName())
                .age(body.getAge())
                .build();
    }
}
