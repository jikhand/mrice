package com.ss.mrice.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_menu")
public class MenuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long menuId;
	private String menuName;
	private String menuPosition;
	private String menuCrBy;
	private String menuUpBy;
	private String appendUrl;
	private String menuCrDate;
	private String menuUpDate;
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuPosition() {
		return menuPosition;
	}
	public void setMenuPosition(String menuPosition) {
		this.menuPosition = menuPosition;
	}
	public String getMenuCrBy() {
		return menuCrBy;
	}
	public void setMenuCrBy(String menuCrBy) {
		this.menuCrBy = menuCrBy;
	}
	public String getMenuUpBy() {
		return menuUpBy;
	}
	public void setMenuUpBy(String menuUpBy) {
		this.menuUpBy = menuUpBy;
	}
	public String getAppendUrl() {
		return appendUrl;
	}
	public void setAppendUrl(String appendUrl) {
		this.appendUrl = appendUrl;
	}
	public String getMenuCrDate() {
		return menuCrDate;
	}
	public void setMenuCrDate(String menuCrDate) {
		this.menuCrDate = menuCrDate;
	}
	public String getMenuUpDate() {
		return menuUpDate;
	}
	public void setMenuUpDate(String menuUpDate) {
		this.menuUpDate = menuUpDate;
	}
	@Override
	public String toString() {
		return "MenuEntity [menuId=" + menuId + ", menuName=" + menuName + ", menuPosition=" + menuPosition
				+ ", menuCrBy=" + menuCrBy + ", menuUpBy=" + menuUpBy + ", appendUrl=" + appendUrl + ", menuCrDate="
				+ menuCrDate + ", menuUpDate=" + menuUpDate + "]";
	}

	

}
