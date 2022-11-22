package com.datajpa.dto.requestDto;

import lombok.Data;

@Data
public class CategoryRequestDto {
	private String CategoryName;

	public CategoryRequestDto() {
		super();

	}

	public CategoryRequestDto(String categoryName) {
		super();
		CategoryName = categoryName;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

}
