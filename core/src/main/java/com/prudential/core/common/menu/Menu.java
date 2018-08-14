package com.prudential.core.common.menu;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Represents Application Menu held by
 * <code>resources/application-menu.xml</code>.
 */

@XmlRootElement(name = "application-menu")
@XmlType(name = "application-menu", namespace = "application")
public class Menu {

	public static final String APPLICATION_MENU_CONFIGURATION = "application-menu.xml";
	private List<MenuItem> menuItems = new ArrayList<>();

	@XmlElement(name = "menu")
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	private static MenuItem create(String name) {
		MenuItem m = new MenuItem();
		m.setName(name);
		m.setPermissions("ADMIN, USER");
		m.setTarget("/stateToGo");
		return m;
	}
}
