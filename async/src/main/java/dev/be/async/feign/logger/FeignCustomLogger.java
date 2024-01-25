package dev.be.async.feign.logger;

import feign.Logger;
import feign.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
public class FeignCustomLogger extends Logger {

    private static final int DEFAULT_SLOW_API_TIME = 3000;
    private static final String SLOW_API_NOTICE = "slow api";

    @Override
    protected void log(String configKey, String format, Object... args) {
        // log를 어떤 형식으로 남길지 정해줌.
        log.info(String.format(methodTag(configKey) + format, args));
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        log.info(String.valueOf(request));
    }

//    @Override
//    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
//        String protocolVersion = resolveProtocolVersion(response.protocolVersion());
//        String reason = response.reason() != null && logLevel.compareTo(Level.NONE) > 0 ? " " + response.reason() : "";
//        int status = response.status();
//        log(configKey, "<-- %s %s%s (%sms)", protocolVersion, status, reason, elapsedTime);
//
//        if(logLevel.ordinal() >= Level.HEADERS.ordinal()) {
//            log.info("");
//        }
//    }
}
