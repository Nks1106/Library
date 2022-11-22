package com.datajpa.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datajpa.dto.Mapper;
import com.datajpa.dto.requestDto.AuthorRequestDto;
import com.datajpa.dto.responseDto.AuthorResponseDto;
import com.datajpa.model.Author;
import com.datajpa.model.Zipcode;
import com.datajpa.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	private final AuthorRepository authorRepository;
	private final ZipcodeService zipcodeService;

	@Autowired
	public AuthorServiceImpl(AuthorRepository authorRepository, ZipcodeService zipcodeService) {
		super();
		this.authorRepository = authorRepository;
		this.zipcodeService = zipcodeService;
	}

	@Transactional
	@Override
	public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
		Author author = new Author();
		author.setAuthorName(authorRequestDto.getAuthorName());
		if (authorRequestDto.getZipId() == null) {
			throw new IllegalArgumentException("author need a zipcode");
		}
		Zipcode zipcode = zipcodeService.getZipcode(authorRequestDto.getZipId());
		author.setZipcode(zipcode);
		authorRepository.save(author);
		return Mapper.authorToAuthorResponseDto(author);
	}

	@Override
	public List<AuthorResponseDto> getAuthors() {
		List<Author> authors = StreamSupport.stream(authorRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Mapper.authorsToAuthorResponseDtos(authors);

	}

	@Override
	public AuthorResponseDto getAuthorById(Long authorId) {
		return Mapper.authorToAuthorResponseDto(getAuthor(authorId));
	}

	@Override
	public Author getAuthor(Long authorId) {
		Author author = authorRepository.findById(authorId)
				.orElseThrow(() -> new IllegalArgumentException("author with id: " + authorId + " could not be found"));
		return author;
	}

	@Override
	public AuthorResponseDto deleteAuthor(Long authorId) {
		Author author = getAuthor(authorId);
		authorRepository.delete(author);
		return Mapper.authorToAuthorResponseDto(author);
	}

	@Transactional
	@Override
	public AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto) {
		Author authorToEdit = getAuthor(authorId);
		authorToEdit.setAuthorName(authorRequestDto.getAuthorName());
		if (authorRequestDto.getZipId() != null) {
			Zipcode zipcode = zipcodeService.getZipcode(authorRequestDto.getZipId());
			authorToEdit.setZipcode(zipcode);
		}
		return Mapper.authorToAuthorResponseDto(authorToEdit);
	}

	@Transactional
	@Override
	public AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId) {
		Author author = getAuthor(authorId);
		Zipcode zipcode = zipcodeService.getZipcode(zipcodeId);
		if (Objects.nonNull(author.getZipcode())) {
			throw new RuntimeException("author already has a zipcode");
		}
		author.setZipcode(zipcode);
		return Mapper.authorToAuthorResponseDto(author);
	}

	@Transactional
	@Override
	public AuthorResponseDto deleteZipcodeFromAuthor(Long authorId) {
		Author author = getAuthor(authorId);
		author.setZipcode(null);
		return Mapper.authorToAuthorResponseDto(author);
	}

}
