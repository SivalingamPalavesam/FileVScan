package com.filescan.dto;

import java.util.Map;

public class ScanResponse<T> {
	private T data;


	public ScanResponse() {
	}

	public ScanResponse(T data) {
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}
