package com.ankith.HibernateProject1.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="person")
public class Person implements Serializable
{
	@Id
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	@Column(name="phone_numb")
	private String phoneNum;
	@OneToOne(cascade=CascadeType.ALL)//use to reference of another table
//	@OneToOne
	private OrderData orderData;
	
	public Person(Integer id, String name, Integer age, String gender, String phoneNum, OrderData orderData) 
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.orderData = orderData;
	}
	public OrderData getOrderData() {
		return orderData;
	}
	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}
	public Person(Integer id, String name, Integer age, String gender, String phoneNum) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phoneNum = phoneNum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", phoneNum=" + phoneNum
				+ ", orderData=" + orderData + "]";
	}
	
}
