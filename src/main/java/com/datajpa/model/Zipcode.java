package com.datajpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Zipcode")
public class Zipcode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long zipId;
	private Long zipNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private City city;

	public Zipcode() {
		super();

	}

	public Zipcode(Long zipId, Long zipNumber, City city) {
		super();
		this.zipId = zipId;
		this.zipNumber = zipNumber;
		this.city = city;
	}

	public Long getZipId() {
		return zipId;
	}

	public void setZipId(Long zipId) {
		this.zipId = zipId;
	}

	public Long getZipNumber() {
		return zipNumber;
	}

	public void setZipNumber(Long zipNumber) {
		this.zipNumber = zipNumber;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
