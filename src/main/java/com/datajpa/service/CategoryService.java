package com.datajpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datajpa.dto.requestDto.CategoryRequestDto;
import com.datajpa.dto.responseDto.CategoryResponseDto;
import com.datajpa.model.Category;

@Service
public interface CategoryService {
	public Category getCategory(long categoryId);

	public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);

	public CategoryResponseDto getCategoryById(Long categoryId);

	public List<CategoryResponseDto> getCategories();

	public CategoryResponseDto deleteCategory(Long categoryId);

	public CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto);
	
}
