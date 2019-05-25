package com.paf.model;

public class SuccessResponse {
	
	private int code;
	
	private boolean status;
	
	private String responseText;

	public SuccessResponse(int code, boolean status, String responseText) {
		super();
		this.code = code;
		this.status = status;
		this.responseText = responseText;
	}
	
	public SuccessResponse() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	
	

}
