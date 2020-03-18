package com.ss.mrice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.mrice.model.MenuEntity;

@Repository
public interface MenuRepositoryImp extends JpaRepository<MenuEntity, Long> {


}
