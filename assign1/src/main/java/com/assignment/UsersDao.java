package com.assignment;

import java.util.ArrayList;

import org.hibernate.mapping.List;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

//import org.hibernate.orm.hibernate.HibernateTemplate;

public class UsersDao {
    HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void saveUser(Users user) {
        template.save(user);
    }

    public void updateUser(Users user) {
        template.update(user);
    }

    public void deleteUser(Users user) {
        template.delete(user);
    }

    public Users getUserById(int id) {
        return template.get(Users.class, id);
    }

    public java.util.List<Users> getAllUsers() {
        // <Users> list=new ArrayList<Users>();
        // list=template.loadAll(Users.class);
        // return list;
        return template.loadAll(Users.class);
    }

}
