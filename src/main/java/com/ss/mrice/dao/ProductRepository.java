package com.ss.mrice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.mrice.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String>{


}
