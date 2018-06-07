package com.zxerjones.entity;

import java.util.List;

public class Category {
	private int id;
	private String name;
	private int type;
	private List<Category> categorys;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", type=" + type
				+ ", categorys=" + categorys + "]";
	}
	
}
