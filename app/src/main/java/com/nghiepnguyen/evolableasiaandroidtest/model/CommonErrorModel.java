package com.nghiepnguyen.evolableasiaandroidtest.model;

/**
 * Created by Nghiep Nguyen on 30-Sep-17.
 */

public class CommonErrorModel {
    private int code;
    private String error;
    public CommonErrorModel() {
    }
    public CommonErrorModel(int code, String error) {
        this.code = code;
        this.error = error;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
