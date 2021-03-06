package com.doancuoiki.demo.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Orders")
public class Order {
	@Id
	private String id;
	private Customer customer;
	private List<OrderDetail> orderlist;
	private Integer total;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<OrderDetail> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<OrderDetail> orderlist) {
		this.orderlist = orderlist;
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
