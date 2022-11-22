package com.datajpa.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryResponseDto {
	private Long categoryId;
	private String categoryName;
	private List<String> bookNames;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getBookNames() {
		return bookNames;
	}

	public void setBookNames(List<String> bookNames) {
		this.bookNames = bookNames;
	}

}
