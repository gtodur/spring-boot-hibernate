package com.df.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserInfo")
public class User implements Serializable{

	private static final long serialVersionUID = -7514628930634353208L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) //default, lets the persistence provider(hibernate here), choose generation strategy
    //@GeneratedValue(strategy=GenerationType.IDENTITY) //persistence provider generates new value during insert operation(auto-increment)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE) //uses database sequence to get next value, AUTO uses this strategy
    //@GeneratedValue(strategy=GenerationType.TABLE) //stores and updated current value storing in DB table, using pessimistic locks
    private int id;

    @Column(name="country")
    private String country;
    @Column(name="name")

    private String name;


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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
