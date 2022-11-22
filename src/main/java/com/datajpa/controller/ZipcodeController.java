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

import com.datajpa.dto.requestDto.ZipcodeRequestDto;
import com.datajpa.model.Zipcode;
import com.datajpa.service.ZipcodeService;

@RestController
@RequestMapping("/api/zipcode")

public class ZipcodeController {
	private final ZipcodeService zipcodeService;

	@Autowired
	public ZipcodeController(ZipcodeService zipcodeService) {
		this.zipcodeService = zipcodeService;
	}

	@PostMapping("/api/add")
	public ResponseEntity<Zipcode> addzipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto) {
		Zipcode zipcode = zipcodeService.addZipcode(zipcodeRequestDto);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}

	@GetMapping("/api/get/{id}")
	public ResponseEntity<Zipcode> getzipcode(@PathVariable final Long id) {
		Zipcode zipcode = zipcodeService.getZipcode(id);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}

	@GetMapping("/api/getAll")
	public ResponseEntity<List<Zipcode>> getZipcode() {
		List<Zipcode> zipcodes = zipcodeService.getZipcodes();
		return new ResponseEntity<>(zipcodes, HttpStatus.OK);
	}

	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<Zipcode> deletezipcode(@PathVariable final Long id) {
		Zipcode zipcode = zipcodeService.deleteZipcode(id);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}

	@PostMapping("/api/edit/{id}")
	public ResponseEntity<Zipcode> editzipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto,
			@PathVariable final Long id) {
		Zipcode zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}

	@PostMapping("/api/addCity/{cityId}/tozipcode/{zipcodeId}")
	public ResponseEntity<Zipcode> addCity(@PathVariable final Long cityId, @PathVariable final Long zipcodeId) {
		Zipcode zipcode = zipcodeService.addCityToZipcode(zipcodeId, cityId);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}

	@PostMapping("/api/deleteCity/{zipcodeId}")
	public ResponseEntity<Zipcode> deleteCity(@PathVariable final Long zipcodeId) {
		Zipcode zipcode = zipcodeService.removeCityFromZipcode(zipcodeId);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
}
