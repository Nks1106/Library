package com.datajpa.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class AuthorResponseDto {
	private Long authorId;
	private String authorName;
	private List<String> bookNames;
	private Long zipNumber;
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<String> getBookNames() {
		return bookNames;
	}

	public void setBookNames(List<String> bookNames) {
		this.bookNames = bookNames;
	}

	public Long getZipNumber() {
		return zipNumber;
	}

	public void setZipNumber(Long zipNumber) {
		this.zipNumber = zipNumber;
	}

}
