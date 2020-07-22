package com.company.ssm.common;

public enum ResEnum {
	SUCCESS(200,"运行成功"),
	ERROR(500,"服务器内部错误"),
	USER_NOT_EXIST(201,"用户名不存在"),
	USER_EXIST(202,"用户名已存在"),
	REG_ERROR(501,"注册错误"),
	NO_DATA_FOUND_ERROR(510,"没有查询到符合条件的数据"),
	ILLEGLE_PARAM(511,"非法参数"),
	NO_SUCH_DATA(512,"查无此数据"),
	PASSWORD_ERROR(509,"密码与用户名不匹配");
	private int status;
	private String msg;
	private ResEnum(int status, String msg) {
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
