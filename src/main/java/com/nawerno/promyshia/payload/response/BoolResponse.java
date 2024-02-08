package com.nawerno.promyshia.payload.response;
public class BoolResponse {
    private Boolean success;

    public BoolResponse(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}