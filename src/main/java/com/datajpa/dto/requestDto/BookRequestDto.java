package com.datajpa.dto.requestDto;

import java.util.List;

import lombok.Data;

@Data
public class BookRequestDto {
	private String bookName;
	private List<Long> authorIds;
	private Long categoryId;

	public BookRequestDto() {
		super();

	}

	public BookRequestDto(String bookName, List<Long> authorIds, Long categoryId) {
		super();
		this.bookName = bookName;
		this.authorIds = authorIds;
		this.categoryId = categoryId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<Long> getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(List<Long> authorIds) {
		this.authorIds = authorIds;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
