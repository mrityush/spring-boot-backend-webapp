package com.src.main.generator;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class ResponseHandler implements ResponseErrorHandler {

    private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();
    private ResponseExecutor responseExecutor;

    public ResponseHandler() {
    }

    public ResponseHandler(ResponseExecutor responseExecutor) {
        this.responseExecutor = responseExecutor;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus httpStatus = response.getStatusCode();
        if (httpStatus == HttpStatus.UNAUTHORIZED) {
            responseExecutor.unauthorizedAccess(response);
        } else if (httpStatus == HttpStatus.FORBIDDEN) {
            responseExecutor.forbidden(response);
        } else if (httpStatus == HttpStatus.BAD_REQUEST) {
            responseExecutor.badRequest(response);
        } else if (httpStatus == HttpStatus.INTERNAL_SERVER_ERROR) {
            responseExecutor.internalServerError(response);
        } else {
            responseExecutor.error(response);
        }
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        boolean hasErr = errorHandler.hasError(response);
        if (!hasErr) {
            responseExecutor.success(response);
        }
        return hasErr;
    }
}
