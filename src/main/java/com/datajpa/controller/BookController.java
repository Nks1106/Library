package com.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datajpa.dto.requestDto.BookRequestDto;
import com.datajpa.dto.responseDto.BookResponseDto;
import com.datajpa.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping("/api/add")
	public ResponseEntity<BookResponseDto> addBook(@RequestBody final BookRequestDto bookRequestDto) {
		BookResponseDto bookResponseDto = bookService.addBook(bookRequestDto);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@GetMapping("/api/get/{id}")
	public ResponseEntity<BookResponseDto> getBook(@PathVariable final Long id) {
		BookResponseDto bookResponseDto = bookService.getBookById(id);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@GetMapping("/api/getAll")
	public ResponseEntity<List<BookResponseDto>> getBooks() {
		List<BookResponseDto> bookResponseDto = bookService.getBooks();
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<BookResponseDto> deleteBook(@PathVariable final Long id) {
		BookResponseDto bookResponseDto = bookService.deleteBook(id);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@PostMapping("/api/edit/{id}")
	public ResponseEntity<BookResponseDto> editBook(@RequestBody final BookRequestDto bookRequestDto,
			@PathVariable final Long id) {
		BookResponseDto bookResponseDto = bookService.editBook(id, bookRequestDto);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@PostMapping("/api/addCategory/{categoryId}/to/{bookId}")
	public ResponseEntity<BookResponseDto> addCategory(@PathVariable final Long categoryId,
			@PathVariable final Long bookId) {
		BookResponseDto bookResponseDto = bookService.addCategoryToBook(bookId, categoryId);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@PostMapping("/api/removeCategory/{categoryId}/from/{bookId}")
	public ResponseEntity<BookResponseDto> removeCategory(@PathVariable final long categoryId,
			@PathVariable final Long bookId) {
		BookResponseDto bookResponseDto = bookService.removeCategoryFromBook(bookId, categoryId);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@PostMapping("/api/addAuthor/{authorId}/to/{bookId}")
	public ResponseEntity<BookResponseDto> addAuthor(@PathVariable final Long authorId,
			@PathVariable final Long bookId) {
		BookResponseDto bookResponseDto = bookService.addAuthorToBook(bookId, authorId);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@PostMapping("/api/removeAuthor/{authorId}/from/{bookId}")
	public ResponseEntity<BookResponseDto> removeAuthor(@PathVariable final long authorId,
			@PathVariable final Long bookId) {
		BookResponseDto bookResponseDto = bookService.deleteAuthorFromBook(bookId, authorId);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}
}
