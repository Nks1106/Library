package com.datajpa.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datajpa.dto.requestDto.ZipcodeRequestDto;
import com.datajpa.model.City;
import com.datajpa.model.Zipcode;
import com.datajpa.repository.ZipcodeRepository;

@Service
public class ZipcodeServiceImpl implements ZipcodeService {

	private final ZipcodeRepository zipcodeRepository;
	private final CityService cityService;

	@Autowired
	public ZipcodeServiceImpl(ZipcodeRepository zipcodeRepository, CityService cityService) {
		super();
		this.zipcodeRepository = zipcodeRepository;
		this.cityService = cityService;
	}

	@Override
	public Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto) {
		Zipcode zipcode = new Zipcode();
		zipcode.setZipNumber(zipcodeRequestDto.getZipNumber());
		if (zipcodeRequestDto.getZipId() == null) {
			return zipcodeRepository.save(zipcode);
		}
		City city = cityService.getCity(zipcodeRequestDto.getZipId());
		zipcode.setCity(city);
		return zipcodeRepository.save(zipcode);
	}

	@Override
	public List<Zipcode> getZipcodes() {

		return StreamSupport.stream(zipcodeRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Zipcode getZipcode(Long zipcodeId) {

		return zipcodeRepository.findById(zipcodeId).orElseThrow(
				() -> new IllegalArgumentException("Zipcode with id: " + zipcodeId + " could not be found"));
	}

	@Override
	public Zipcode deleteZipcode(Long zipcodeId) {
		Zipcode zipcode = getZipcode(zipcodeId);
		zipcodeRepository.delete(zipcode);
		return zipcode;
	}

	@Transactional
	@Override
	public Zipcode editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto) {
		Zipcode zipcodeToEdit = getZipcode(zipcodeId);
		zipcodeToEdit.setZipNumber(zipcodeRequestDto.getZipNumber());
		if (zipcodeRequestDto.getZipId() == null) {
			return zipcodeToEdit;
		}
		City city = cityService.getCity(zipcodeRequestDto.getZipId());
		zipcodeToEdit.setCity(city);
		return zipcodeToEdit;
	}

	@Transactional
	@Override
	public Zipcode addCityToZipcode(Long zipcodeId, Long cityId) {
		Zipcode zipcode = getZipcode(zipcodeId);
		City city = cityService.getCity(cityId);
		if (Objects.nonNull(zipcode.getCity())) {
			throw new IllegalArgumentException("Zipcode already has a city");
		}
		zipcode.setCity(city);
		return zipcode;
	}

	@Transactional
	@Override
	public Zipcode removeCityFromZipcode(Long zipcodeId) {
		Zipcode zipcode = getZipcode(zipcodeId);
		if (!Objects.nonNull(zipcode.getCity())) {
			throw new IllegalArgumentException("Zipcode does not have a city");
		}
		zipcode.setCity(null);
		return zipcode;
	}

}
