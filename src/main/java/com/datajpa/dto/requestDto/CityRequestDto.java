package com.datajpa.dto.requestDto;

import lombok.Data;

@Data
public class CityRequestDto {
	private String cityName;
	private Long cityId;

	public CityRequestDto() {
		super();

	}

	public CityRequestDto(String cityName, Long cityId) {
		super();
		this.cityName = cityName;
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

}
