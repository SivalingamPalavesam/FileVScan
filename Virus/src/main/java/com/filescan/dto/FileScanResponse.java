package com.filescan.dto;

public class FileScanResponse {
	private String fileName;
	private Boolean detected;
	private String fileType;
	private long size;
	private long scanTimeInMilliSec;
	private String errorMessage;
	private long uploadTime;

	public FileScanResponse(String fileName, Boolean detected, String fileType, long size, long scanTimeInMilliSec,
			String errorMessage, long uploadTime) {
		super();
		this.fileName = fileName;
		this.detected = detected;
		this.fileType = fileType;
		this.size = size;
		this.scanTimeInMilliSec = scanTimeInMilliSec;
		this.errorMessage = errorMessage;
		this.uploadTime = uploadTime;
	}

	public FileScanResponse() {
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getScanTimeInMilliSec() {
		return scanTimeInMilliSec;
	}

	public void setScanTimeInMilliSec(long scanTimeInMilliSec) {
		this.scanTimeInMilliSec = scanTimeInMilliSec;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public long getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(long uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Boolean getDetected() {
		return detected;
	}

	public void setDetected(Boolean detected) {
		this.detected = detected;
	}
}