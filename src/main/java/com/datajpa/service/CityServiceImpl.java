package com.datajpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datajpa.dto.requestDto.CityRequestDto;
import com.datajpa.model.City;
import com.datajpa.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	private final CityRepository cityRepository;

	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public City addCity(CityRequestDto cityRequestDto) {
		City city = new City();
		city.setCityName(cityRequestDto.getCityName());

		return cityRepository.save(city);
	}

	@Override
	public List<City> getCities() {
		List<City> cities = new ArrayList<>();
		cityRepository.findAll().forEach(cities::add);
		return cities;
	}

	@Override
	public City getCity(Long cityId) {

		return cityRepository.findById(cityId)
				.orElseThrow(() -> new IllegalArgumentException("city with cityId: " + cityId + " could not be found"));
	}

	@Override
	public City deleteCity(Long cityId) {
		City city = getCity(cityId);
		cityRepository.delete(city);
		return city;
	}

	@Transactional
	@Override
	public City editCity(Long cityId, CityRequestDto cityRequestDto) {
		City cityToEdit = getCity(cityId);
		cityToEdit.setCityName(cityRequestDto.getCityName());
		return cityToEdit;
	}

}
