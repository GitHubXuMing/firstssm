package com.company.ssm.common;

public enum ResEnum {
    SUCCESS(200,"success"),ERROR(500,"error");
    private int status;
    private String msg;

    ResEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
