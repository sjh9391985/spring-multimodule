package dev.be.async.feign.client;

import dev.be.async.common.dto.BaseRequestInfo;
import dev.be.async.common.dto.BaseResponseInfo;
import dev.be.async.feign.config.DemoFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "demo-client",
        url = "${feign.url.prefix}",
        configuration = DemoFeignConfig.class
)
public interface DemoFeignClient {

    @GetMapping("/get")
    ResponseEntity<BaseResponseInfo> callGet(
            @RequestHeader("CustomHeaderName") String customHeader,
            @RequestParam("name") String name,
            @RequestParam("age") Long age
            );

    @PostMapping("/post")
    ResponseEntity<BaseResponseInfo> callPost(
            @RequestHeader("CustomHeaderName") String customHeader,
            @RequestBody BaseRequestInfo baseRequestInfo
            );

}
