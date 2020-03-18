package com.ss.mrice.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ss.mrice.dao.ProductRepository;
import com.ss.mrice.model.ProductEntity;
import com.ss.mrice.util.FileUpload;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	FileUpload fileUpload;

	String msg;

	ProductEntity productEntity;

	DateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");

	public String createProductService(List<MultipartFile> list, ProductEntity entity) throws IOException {
		Calendar cl = Calendar.getInstance();
		entity.setCDateTime(df.format(cl.getTime()));
		if (entity != null && list != null) {
			productEntity = productRepository.save(entity);
			if (productEntity != null) {
				fileUpload.saveUploadFiles(list);
				msg = "product "+productEntity.getProductId()+"  create success ";
			}
		}
		return msg;

	}

	public String createProductAndInformation(ProductEntity product) {
		// product.getProductInformation().setProductEntity(product);
		ProductEntity pe = productRepository.save(product);
		if (pe.getProductId() != null)
			msg = pe.getProductId() + "create success";
		else
			msg = "Fail to create product";
		return msg;
	}

}
