package com.datajpa.dto.requestDto;

import lombok.Data;

@Data
public class AuthorRequestDto {
	private String authorName;
	private Long zipId;

	public AuthorRequestDto() {
		super();

	}

	public AuthorRequestDto(String authorName, Long zipId) {
		super();
		this.authorName = authorName;
		this.zipId = zipId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Long getZipId() {
		return zipId;
	}

	public void setZipId(Long zipId) {
		this.zipId = zipId;
	}

}
