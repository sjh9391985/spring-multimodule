package dev.be.async.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.*;

import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {

        // get 요청의 경우
        if(requestTemplate.method() == Request.HttpMethod.GET.name()) {
            log.info("[GET] [DemoFeignInterceptor] queries : " + requestTemplate.queries());
            return;
        }

        // post 요청의 경우
        String encodedRequestBody = StringUtils.toEncodedString(requestTemplate.body(), StandardCharsets.UTF_8);
        requestTemplate.body(encodedRequestBody);
    }
}
