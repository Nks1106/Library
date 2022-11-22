package com.datajpa.dto.requestDto;

import lombok.Data;

@Data
public class ZipcodeRequestDto {
	private Long zipNumber;
	private Long zipId;

	public ZipcodeRequestDto() {
		super();

	}

	public ZipcodeRequestDto(Long zipNumber, Long zipId) {
		super();
		this.zipNumber = zipNumber;
		this.zipId = zipId;
	}

	public Long getZipNumber() {
		return zipNumber;
	}

	public void setZipNumber(Long zipNumber) {
		this.zipNumber = zipNumber;
	}

	public Long getZipId() {
		return zipId;
	}

	public void setZipId(Long zipId) {
		this.zipId = zipId;
	}

}
