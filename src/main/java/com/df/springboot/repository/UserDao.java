package com.df.springboot.repository;

import java.util.List;

import com.df.springboot.model.User;

public interface UserDao {
    public void addUser(User user);
    public List<User> getUser();
    public User findById(int id);
    public User update(User user, int id);
    public User updateCountry(User user, int id);
    public void delete(int id);
    
    public void testMethod();
}