package org.gandalf.entity;

import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * 购物车
 * 
 * @author subin
 */
@Component
public class Cart {
	
	private long userId;
	
	private Set<Items> items;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}
}