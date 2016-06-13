package com.src.main.generator;

import org.springframework.http.client.ClientHttpResponse;

public interface ResponseExecutor {

    /**
     * HttpStatus.BAD_REQUEST(400,"Bad Request")
     */
    void badRequest(ClientHttpResponse response);

    /**
     * Used to handle any other responses.
     */
    void error(ClientHttpResponse response);

    /**
     * HttpStatus.FORBIDDEN(403, "Forbidden")
     */
    void forbidden(ClientHttpResponse response);

    /**
     * HttpStatus.INTERNAL_SERVER_ERROR(500,"Internal Server Error")
     */
    void internalServerError(ClientHttpResponse response);

    /**
     * HttpStatus.OK(200, "OK")
     */
    void success(ClientHttpResponse response);

    /**
     * HttpStatus.UNAUTHORIZED(401, "Unauthorized")
     */
    void unauthorizedAccess(ClientHttpResponse response);
}
