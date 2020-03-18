package com.ss.mrice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ss.mrice.helper.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "tbl_product_information")
public class ProductInformationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_inf_seq")
	@GenericGenerator(name = "prod_inf_seq", strategy = "com.ss.mrice.helper.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PINF_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "product_information_id")
	private String productInformationId;
	private String volume;
	private String format;
	private String weight;
	private String units;
	private String origin;
	private String brand;
	private String manufacturer;
	private String specialty;

	public ProductInformationEntity() {
		super();
	}

	public String getProductInformationId() {
		return productInformationId;
	}

	public void setProductInformationId(String productInformationId) {
		this.productInformationId = productInformationId;
	}
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getItemWeight() {
		return weight;
	}

	public void setItemWeight(String itemWeight) {
		this.weight = itemWeight;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	/*
	 * public ProductEntity getProductEntity() { return productEntity; }
	 * 
	 * public void setProductEntity(ProductEntity productEntity) {
	 * this.productEntity = productEntity; }
	 */


}
