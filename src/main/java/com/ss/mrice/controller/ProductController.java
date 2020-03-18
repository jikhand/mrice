package com.ss.mrice.controller;


import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.mrice.model.ProductEntity;
import com.ss.mrice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	ProductEntity productEntity;
	String msg = "";
	ObjectMapper mapper;

	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "/createProduct", method = RequestMethod.POST)
	// @Consumes({ MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_XML,
	// MediaType.APPLICATION_JSON })
	public String createProductController(@RequestParam("file") MultipartFile uploadfile,
			HttpServletRequest product) {
		
		try {
			System.out.println("CTCTS:::"+product.getParameter("product"));
			 mapper = new ObjectMapper();
			ProductEntity entity = mapper.readValue(product.getParameter("product"), ProductEntity.class);
			System.out.println("entity::"+entity);
			msg = productService.createProductService(Arrays.asList(uploadfile), entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/createProductAndInformation", method = RequestMethod.POST)
	public String createProductAndInformationController(@RequestBody ProductEntity product) {
		return productService.createProductAndInformation(product);
	}

}
