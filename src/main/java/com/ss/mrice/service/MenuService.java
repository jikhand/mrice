package com.ss.mrice.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.mrice.dao.MenuRepository;
import com.ss.mrice.dao.MenuRepositoryImp;
import com.ss.mrice.model.MenuEntity;

@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;

	@Autowired
	MenuRepositoryImp menuRepositoryImp;

	int count = 0;

	String date = new SimpleDateFormat("yyyy-M-dd hh:mm:ss").format(new Date());

	String msg = "";

	public List<MenuEntity> getSidemenu() {
		return menuRepository.getSidemenu();

	}

	public List<MenuEntity> createMenuService(List<MenuEntity> entity) {
		entity.forEach(action -> action.setMenuCrDate(date));
		return menuRepositoryImp.saveAll(entity);

	}

	public List<MenuEntity> getAllMenuDiscByDateTimeService() {
		return menuRepository.getAllMenuDiscByDateTimeDao();
	}

	public List<MenuEntity> getAllMenuByPositionService(String position) {
		return menuRepository.getAllMenuByPositionDao(position);
	}

	// This method is used for update the menu according by id
	public String updateMenuService(MenuEntity entity) {
		MenuEntity menu = null;
		try {
			if (entity.getMenuId() != null) {
				menu = menuRepositoryImp.getOne(entity.getMenuId());
				System.out.println(menu);
				menu.setMenuId(entity.getMenuId());
				menu.setMenuName(entity.getMenuName());
				menu.setMenuPosition(entity.getMenuPosition());
				menu.setAppendUrl(entity.getAppendUrl());
				menu.setMenuUpDate(date);
				menu.setMenuUpBy("jitesh");

				menuRepositoryImp.save(menu);

				msg = menu.getMenuId() + " successfully updated";
			} else {
				//msg = menu.getMenuId() + " not updated";
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return msg;
	}

	// This method used for delete the menu according by id
	public String deleteMenuService(Long id) {
		if (id != null) {
			try {
				menuRepositoryImp.deleteById(id);
				msg = id + "delete successfully";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			msg = "Please enter id";
		}

		return msg;
	}
}
