package org.gandalf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 订单
 * 
 * @author subin
 */
@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	// 商品
	
	// 收件人
	
	
	// 状态
	private long status;
	
	// 订单跟踪
	@OneToMany
	private OrderTrack orderTrack;
	
	
}
