package com.src.main.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.src.main.dto.RequestBuilderDTO;
import com.src.main.generator.ResponseExecutor;
import com.src.main.generator.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ApiRequestBuilder {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private RestTemplate restTemplate;

    public <T> ResponseEntity<T> executeRequest(RequestBuilderDTO requestBuilderData, Class<T> responseClass) throws JsonProcessingException {
        return restTemplate.exchange(
                requestBuilderData.getUrl(),
                requestBuilderData.getHttpMethod(),
                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBuilderData.getRequestBody()), requestBuilderData.getHttpHeaders()),
                responseClass);
    }

    public <T> ResponseEntity<T> executeRequest(RequestBuilderDTO requestBuilderData, Class<T> responseClass, ResponseExecutor responseExecutor) throws JsonProcessingException {
        restTemplate.setErrorHandler(new ResponseHandler(responseExecutor));
        return restTemplate.exchange(
                requestBuilderData.getUrl(),
                requestBuilderData.getHttpMethod(),
                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBuilderData.getRequestBody()), requestBuilderData.getHttpHeaders()),
                responseClass);
    }

}
