package com.df.springboot.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.df.springboot.model.Account;
import com.df.springboot.model.Employee;
import com.df.springboot.model.User;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public List<User> getUser() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<User> list= session.createCriteria(User.class).list();
        return list;
    }

    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user=(User) session.get(User.class,id);
        return user;
    }

    public User update(User val, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user =(User)session.get(User.class, id);
        user.setCountry(val.getCountry());
        user.setName(val.getName());
        session.update(user);
        return user;
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = findById(id);
        session.delete(user);
    }
    @Override
    public User updateCountry(User val, int id){
        Session session = sessionFactory.getCurrentSession();
        User user = (User)session.load(User.class, id);
        user.setCountry(val.getCountry());
        return user;
    }
    
    @Override
    public void testMethod() {
    	Session session = sessionFactory.getCurrentSession();
    	
//    	Account a = new Account();
//    	a.setAccountNumber("1234567890");
//    	session.save(a);
//    	Employee e = new Employee("India", "Guru");
//    	e.setAccount(a);
//    	session.saveOrUpdate(e);
    	Employee e = session.get(Employee.class, 11);
    	e.getAccount().setAccountNumber("67890");
    	session.saveOrUpdate(e);
    	
    }

}
