package com.df.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -375380170256401443L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    @Column(name="country")
    private String country;
    
    @Column(name="name")
    private String name;
    
    public Employee() {
    	
    }
    
    public Employee(String country, String name) {
		this.country = country;
		this.name = name;
	}
	@OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", country=" + country + ", name=" + name + ", account=" + account + "]";
	}

}
