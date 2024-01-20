package dev.be.moduleapi.service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DemoService {

    private final CommonDemoService commonDemoService;

    public String save(){
        log.info(commonDemoService.commonService());
        return "save";
    }

    public String find(){
        return "find";
    }

    public String exception() {
        if(true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "exception";
    }
}
