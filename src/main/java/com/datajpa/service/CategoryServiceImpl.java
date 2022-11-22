package com.datajpa.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datajpa.dto.Mapper;
import com.datajpa.dto.requestDto.CategoryRequestDto;
import com.datajpa.dto.responseDto.CategoryResponseDto;
import com.datajpa.model.Category;
import com.datajpa.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category getCategory(long categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new IllegalArgumentException("could not find category with id: " + categoryId));
	}

	@Override
	public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
		Category category = new Category();
		category.setCategoryName(categoryRequestDto.getCategoryName());
		categoryRepository.save(category);
		return Mapper.categoryToCategoryResponseDto(category);
	}

	@Override
	public CategoryResponseDto getCategoryById(Long categoryId) {
		Category category = getCategory(categoryId);
		return Mapper.categoryToCategoryResponseDto(category);
	}

	@Override
	public List<CategoryResponseDto> getCategories() {
		List<Category> categories = StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Mapper.categoriesToCategoryResponseDtos(categories);
	}

	@Override
	public CategoryResponseDto deleteCategory(Long categoryId) {
		Category category = getCategory(categoryId);
		categoryRepository.delete(category);
		return Mapper.categoryToCategoryResponseDto(category);
	}

	@Transactional
	@Override
	public CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto) {
		Category categorytoEdit = getCategory(categoryId);
		categorytoEdit.setCategoryName(categoryRequestDto.getCategoryName());
		return Mapper.categoryToCategoryResponseDto(categorytoEdit);
	}

}
