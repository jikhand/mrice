package com.ss.mrice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.mrice.model.MenuEntity;
import com.ss.mrice.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	MenuService menuService;

	@GetMapping("/getSideMenu")
	@ResponseBody
	List<MenuEntity> getSidemenu() {
		return menuService.getSidemenu();
	}

	@PostMapping("/createMenu")
	@ResponseBody
	List<MenuEntity> createMenuController(@RequestBody List<MenuEntity> entity) {
		System.out.println(entity);
		return menuService.createMenuService(entity);
	}

	@GetMapping("/getAllMenuDiscByDateTime")
	@ResponseBody
	List<MenuEntity> getAllMenuDiscByDateTimeController() {
		return menuService.getAllMenuDiscByDateTimeService();
	}

	@GetMapping("/getAllMenuByPosition")
	@ResponseBody
	public List<MenuEntity> getAllMenuByPositionController(@RequestBody @RequestParam("position") String position) {
		return menuService.getAllMenuByPositionService(position);
	}

	@PostMapping("/updateMenu/{id}")
	@ResponseBody
	String updateMenuController(@RequestBody MenuEntity entity,@PathVariable("id") String id) {
		entity.setMenuId(Long.decode(id));
		return menuService.updateMenuService(entity);
	}
	@GetMapping("/deleteMenu/{id}")
	@ResponseBody
	String deleteMenuController(@PathVariable("id") String id) {
		return menuService.deleteMenuService(Long.decode(id));
	}

}
