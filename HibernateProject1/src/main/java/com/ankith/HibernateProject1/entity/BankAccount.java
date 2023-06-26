package com.ankith.HibernateProject1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="bank_account")
public class BankAccount 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="bank_name",nullable=false)
	private String bankName;
	@Column(nullable=false,unique=true,name="account_number")
	private String accountNumber;
	
	public BankAccount() {
		super();
	}
	
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", bankName=" + bankName + ", accountNumber=" + accountNumber + "]";
	}

	public BankAccount(String bankName, String accountNumber) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
