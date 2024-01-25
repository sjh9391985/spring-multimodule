package dev.be.async.service;

import dev.be.async.common.dto.BaseRequestInfo;
import dev.be.async.common.dto.BaseResponseInfo;
import dev.be.async.feign.client.DemoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DemoService {

    private final DemoFeignClient demoFeignClient;

    public String get() {
        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("CustomHeader", "CustomName", 1L);
        return "get";
    }

    public String post() {
        BaseRequestInfo baseRequestInfo = BaseRequestInfo.
        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callPost("CustomHeader", "CustomName", 1L);
        return "post";
    }
    public String errorDecoder() {
        demoFeignClient.callErrorDecoder();
        return "error";
    }

}
