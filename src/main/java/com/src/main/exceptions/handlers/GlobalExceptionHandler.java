package com.src.main.exceptions.handlers;

import com.src.main.constants.ApplicationConstant;
import com.src.main.dto.RequestResponseDTO;
import com.src.main.enums.exceptions.CustomExceptionEnum;
import com.src.main.exceptions.classes.ErrorObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sanjeev on 15/2/16.
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    static final ErrorObject OBJECT = new ErrorObject();

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Throwable.class)
    public RequestResponseDTO handle(Throwable e) {
        log.debug("###############GLOBAL EXCEPTION HANDLER#####################");
        RequestResponseDTO requestResponseDTO = new RequestResponseDTO(false);
        requestResponseDTO.setStatus(ApplicationConstant.SERVER_ERROR);
        requestResponseDTO.setMessage(CustomExceptionEnum.GENERIC_EXCEPTION.getKey());
        requestResponseDTO.setData(OBJECT);
        requestResponseDTO.setIsActionDone(false);
        log.debug("@@@@@@@@@@@@ EXCEPTION STACK TRACE START @@@@@@@@@@@@@@@@@@@");
        e.printStackTrace(System.out);
        log.debug("@@@@@@@@@@@@@ EXCEPTION STACK TRACE END   @@@@@@@@@@@@@@@@@@");
        return requestResponseDTO;
    }
}
