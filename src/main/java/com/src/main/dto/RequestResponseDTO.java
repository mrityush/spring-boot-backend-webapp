package com.src.main.dto;

/**
 * Created by mj on 1/6/16.
 */
public class RequestResponseDTO {
    private String message;
    private Integer status;
    private boolean isActionDone;
    private Object data;
    private String nextCursor;

    public RequestResponseDTO() {
        status = 200;
        message = "dummy Message";
        isActionDone = false;
    }

    public RequestResponseDTO(boolean b) {
        status = 200;
        message = "dummy Message";
        isActionDone = b;
    }

    public boolean getIsActionDone() {
        return isActionDone;
    }

    public void setIsActionDone(boolean isActionDone) {
        this.isActionDone = isActionDone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }
}
