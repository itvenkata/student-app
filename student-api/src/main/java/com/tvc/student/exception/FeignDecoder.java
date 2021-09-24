package com.tvc.student.exception;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class FeignDecoder implements ErrorDecoder {

    private static final String FIND_COURSE_CODE = "CourseClient.findByCourseCode";

    @Override
    public Exception decode(String methodKey, Response response) {
        if (StringUtils.contains(methodKey, "CourseClient.findByCourseCode(String)") &&
                response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return new RetryableException(response.status(), methodKey, null, new Date(System.currentTimeMillis()), response.request());
        }
        return new ErrorDecoder.Default().decode(methodKey, response);
    }
}
