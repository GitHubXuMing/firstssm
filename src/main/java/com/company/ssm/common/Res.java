package com.company.ssm.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Res<T> {
    private int status;
    private String msg;
    private T data;

    private Res(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private Res(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static<T> Res<T> success(T data){
        return new Res(ResEnum.SUCCESS.getStatus(),ResEnum.SUCCESS.getMsg(),data);
    }

    public static Res error(){
        return new Res(ResEnum.ERROR.getStatus(),ResEnum.ERROR.getMsg());
    }
}
