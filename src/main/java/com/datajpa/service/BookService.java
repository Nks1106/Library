package com.datajpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datajpa.dto.requestDto.BookRequestDto;
import com.datajpa.dto.responseDto.BookResponseDto;
import com.datajpa.model.Book;

@Service
public interface BookService {

	public BookResponseDto addBook(BookRequestDto bookReqeustDto);

	public BookResponseDto getBookById(Long bookId);

	public Book getBook(Long bookId);

	public List<BookResponseDto> getBooks();

	public BookResponseDto deleteBook(Long bookId);

	public BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto);

	public BookResponseDto addAuthorToBook(Long bookId, Long authorId);

	public BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId);

	public BookResponseDto addCategoryToBook(Long bookId, Long categoryId);

	public BookResponseDto removeCategoryFromBook(Long bookId, Long categoryId);
}
