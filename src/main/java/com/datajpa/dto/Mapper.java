package com.datajpa.dto;

import java.util.ArrayList;
import java.util.List;

import com.datajpa.dto.responseDto.AuthorResponseDto;
import com.datajpa.dto.responseDto.BookResponseDto;
import com.datajpa.dto.responseDto.CategoryResponseDto;
import com.datajpa.model.Author;
import com.datajpa.model.Book;
import com.datajpa.model.Category;

public class Mapper {
	public static BookResponseDto bookToBookResponseDto(Book book) {
		BookResponseDto bookResponseDto = new BookResponseDto();
		bookResponseDto.setBookId(book.getBookId());
		bookResponseDto.setCategoryName(book.getCategory().getCategoryName());
		bookResponseDto.setBookName(book.getBookName());
		List<String> names = new ArrayList<>();
		List<Author> authors = book.getAuthors();
		for (Author author : authors) {
			names.add(author.getAuthorName());
		}
		bookResponseDto.setAuthorNames(names);
		return bookResponseDto;
	}

	public static List<BookResponseDto> booksToBookResponseDtos(List<Book> books) {
		List<BookResponseDto> bookResponseDtos = new ArrayList<>();
		for (Book book : books) {
			bookResponseDtos.add(bookToBookResponseDto(book));
		}
		return bookResponseDtos;
	}

	public static AuthorResponseDto authorToAuthorResponseDto(Author author) {
		AuthorResponseDto authorResponseDto = new AuthorResponseDto();
		authorResponseDto.setAuthorId(author.getAuthorId());
		authorResponseDto.setAuthorName(author.getAuthorName());
		authorResponseDto.setZipNumber(author.getZipcode().getZipNumber());
		authorResponseDto.setCityName(author.getZipcode().getCity().getCityName());
		List<String> names = new ArrayList<>();
		List<Book> books = author.getBooks();
		for (Book book : books) {
			names.add(book.getBookName());
		}
		authorResponseDto.setBookNames(names);
		return authorResponseDto;
	}

	public static List<AuthorResponseDto> authorsToAuthorResponseDtos(List<Author> authors) {
		List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
		for (Author author : authors) {
			authorResponseDtos.add(authorToAuthorResponseDto(author));
		}
		return authorResponseDtos;
	}

	public static CategoryResponseDto categoryToCategoryResponseDto(Category category) {
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		categoryResponseDto.setCategoryId(category.getCategoryId());
		categoryResponseDto.setCategoryName(category.getCategoryName());
		List<String> names = new ArrayList<>();
		List<Book> books = category.getBooks();
		for (Book book : books) {
			names.add(book.getBookName());
		}
		categoryResponseDto.setBookNames(names);
		return categoryResponseDto;
	}

	public static List<CategoryResponseDto> categoriesToCategoryResponseDtos(List<Category> categories) {
		List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
		for (Category category : categories) {
			categoryResponseDtos.add(categoryToCategoryResponseDto(category));
		}
		return categoryResponseDtos;
	}
}
