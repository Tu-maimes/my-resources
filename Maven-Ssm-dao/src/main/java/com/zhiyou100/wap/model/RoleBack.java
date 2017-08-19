package com.zhiyou100.wap.model;

import java.util.Arrays;
import java.util.List;

public class RoleBack {
	private Role re;
	private String[] st;
	private List<Role> itemList;
	
	

	

	public List<Role> getItemList() {
		return itemList;
	}

	public void setItemList(List<Role> itemList) {
		this.itemList = itemList;
	}

	public String[] getSt() {
		return st;
	}

	public void setSt(String[] st) {
		this.st = st;
	}

	public Role getRe() {
		return re;
	}

	public void setRe(Role re) {
		this.re = re;
	}

	@Override
	public String toString() {
		return "RoleBack [re=" + re + ", st=" + Arrays.toString(st) + ", itemList=" + itemList + "]";
	}

	

}
