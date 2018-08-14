package com.prudential.core.common.menu;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Menu item representation for Application or Module.
 */

@XmlType(name = "menu")
public class MenuItem {
    private String name;
    private String icon;
    private String target;
    private float priority;
    private String permissions;
    private List<MenuItem> subMenu = new ArrayList<>();

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    @XmlAttribute
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    @XmlAttribute
    public void setTarget(String target) {
        this.target = target;
    }

    public float getPriority() {
        return priority;
    }

    @XmlAttribute
    public void setPriority(float priority) {
        this.priority = priority;
    }

    public String getPermissions() {
        return permissions;
    }

    @XmlAttribute
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public List<MenuItem> getSubMenu() {
        return subMenu;
    }

    @XmlElement(name = "sub-menu")
    public void setSubMenu(List<MenuItem> subMenu) {
        this.subMenu = subMenu;
    }
}
