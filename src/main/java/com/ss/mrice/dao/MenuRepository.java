package com.ss.mrice.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ss.mrice.model.MenuEntity;


@Repository
public class MenuRepository {
	
	@Autowired 
	EntityManager entityManager;
	javax.persistence.Query q;
	String msg="";
	String date = new SimpleDateFormat("yyyy-M-dd hh:mm:ss").format(new Date());
	
			
	@SuppressWarnings("unchecked")
	public List<MenuEntity> getSidemenu(){
		q = entityManager.createNativeQuery("SELECT MENU_ID,MENU_NAME FROM TBL_MENU");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<MenuEntity> getAllMenuDiscByDateTimeDao() {
	   q = entityManager.createNativeQuery("SELECT * FROM tbl_menu ORDER BY menu_cr_date DESC",MenuEntity.class);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<MenuEntity> getAllMenuByPositionDao(String position){
		q = entityManager.createNativeQuery("SELECT * FROM tbl_menu WHERE menu_position=?",MenuEntity.class).setParameter(1, position);
		return q.getResultList();
	}
	
}



