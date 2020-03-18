package com.ss.mrice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ss.mrice.helper.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "tbl_product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
	@GenericGenerator(name = "prod_seq", strategy = "com.ss.mrice.helper.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROD_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String productId;
	private String productName;
	private String productDesc;
	private String CDateTime;
	private String uDateTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_inf_fk")
	private ProductInformationEntity productInformation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="prod_img_fk")
	private FileUploadEntity fileUploadEntity;

	public ProductEntity() {
		super();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getCDateTime() {
		return CDateTime;
	}

	public void setCDateTime(String cDateTime) {
		CDateTime = cDateTime;
	}

	public String getuDateTime() {
		return uDateTime;
	}

	public void setuDateTime(String uDateTime) {
		this.uDateTime = uDateTime;
	}

	public ProductInformationEntity getProductInformation() {
		return productInformation;
	}

	public void setProductInformation(ProductInformationEntity productInformation) {
		this.productInformation = productInformation;
	}

	public FileUploadEntity getFileUploadEntity() {
		return fileUploadEntity;
	}

	public void setFileUploadEntity(FileUploadEntity fileUploadEntity) {
		this.fileUploadEntity = fileUploadEntity;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", CDateTime=" + CDateTime + ", uDateTime=" + uDateTime + ", productInformation=" + productInformation
				+ ", fileUploadEntity=" + fileUploadEntity + "]";
	}

	
}
