package com.ss.mrice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.mrice.model.ProductEntity;

@Repository
public interface ProductDao extends CrudRepository<ProductEntity, String> {

}
