package com.src.main.exceptions.handlers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.src.main.dto.RequestResponseDTO;
import com.src.main.exceptions.classes.ErrorObject;
import com.src.main.exceptions.classes.GenericException;
import com.src.main.exceptions.classes.InvalidUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    private Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);
    static final ErrorObject OBJECT = new ErrorObject();

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RequestResponseDTO handle(HttpMessageNotReadableException exc) {
        RequestResponseDTO requestResponseDTO = new RequestResponseDTO(false);
        JsonMappingException jme = (JsonMappingException) exc.getCause();
        requestResponseDTO.setMessage(jme.getPath().get(0).getFieldName() + " is invalid");
        requestResponseDTO.setData(OBJECT);
        requestResponseDTO.setIsActionDone(false);
        return requestResponseDTO;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = GenericException.class)
    public RequestResponseDTO handleGenericException(GenericException exc) {
        RequestResponseDTO requestResponseDTO = new RequestResponseDTO(false);
        requestResponseDTO.setMessage(exc.key);
        requestResponseDTO.setData(OBJECT);
        requestResponseDTO.setIsActionDone(false);
        return requestResponseDTO;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = InvalidUserException.class)
    public RequestResponseDTO handleInvalidUserException(InvalidUserException exc) {
        RequestResponseDTO requestResponseDTO = new RequestResponseDTO(false);
        requestResponseDTO.setMessage(exc.key);
        requestResponseDTO.setData(OBJECT);
        requestResponseDTO.setIsActionDone(false);
        return requestResponseDTO;
    }
}