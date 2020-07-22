package com.company.ssm.common;

public class Res<T> {
	private int status;
	private String msg;
	private T data;
	
	public Res(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public Res(int status, String msg, T data) {
		super();
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

	@Override
	public String toString() {
		return "Res [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}

	public static<T> Res<T> success(ResEnum re,T data){
		return new Res<T>(re.getStatus(),re.getMsg(),data);
	}
	public static Res success(ResEnum re) {
		return new Res(re.getStatus(),re.getMsg());
	}
	public static Res success() {
		return new Res(ResEnum.SUCCESS.getStatus(),ResEnum.SUCCESS.getMsg());
	}
	public static Res error(ResEnum re) {
		return new Res(re.getStatus(),re.getMsg());
	}
	public static Res error() {
		return new Res(ResEnum.ERROR.getStatus(),ResEnum.ERROR.getMsg());
	}
}
