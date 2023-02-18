package com.wecode.response;

import java.util.Date;

public class Response {
	private Date date;
	private Object data;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(Date date, Object data) {
		super();
		this.date = date;
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [date=" + date + ", data=" + data + "]";
	}

}