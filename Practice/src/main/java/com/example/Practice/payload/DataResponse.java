package com.example.Practice.payload;

public class DataResponse {
	
	private String status = "200";
	private String decs;
	private boolean isSucces = true;
	private Object data;

	public boolean isSucces() {
		return isSucces;
	}

	public void setSucces(boolean succes) {
		isSucces = succes;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDecs() {
		return decs;
	}
	public void setDecs(String decs) {
		this.decs = decs;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
