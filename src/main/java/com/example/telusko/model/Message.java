package com.example.telusko.model;

public class Message {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg;
	}

//	public Message(String msg) {
//		super();
//		this.msg = msg;
//	}
	
}
