package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.CustomerDAO;
import org.example.entity.Customer;
import org.example.entity.Item;
import org.example.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {

        Session sessions = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = sessions.beginTransaction();


        sessions.save(entity);

        transaction.commit();
        sessions.close();

        return true;
    }


    public List<Customer> getAll() {

        Session session = FactoryConfiguration.getInstance().getSession();
        Query<Customer> query = session.createQuery("from Customer");
        List<Customer> customers = query.list();
        session.close();

        return customers;
    }

    public boolean update(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.update(customer);

        transaction.commit();
        session.close();

        return true;
    }


    public boolean delete(String tel) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("DELETE FROM Customer WHERE tel = :tel").setParameter("tel", tel)
                .executeUpdate();
        transaction.commit();
        session.close();

        return true;
    }

    public String getName(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<String> query = session.createQuery("select name from Customer where id =:id ").setParameter("id",id);
        String name = query.getSingleResult();
        session.close();

        return name;

    }

    public List<String> getIds() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<String> query = session.createNativeQuery("select ID from Customer");
        List<String> clist = query.list();
        session.close();
        return clist;
    }

    @Override
    public Customer getdata(String cid) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<Customer> query = session.createQuery("from Customer where ID =:id ").setParameter("id",cid);
        Customer item = query.getSingleResult();
        session.close();

        return item;
    }
}

/*
ResultSet resultSet = SQLUtil.execute("SELECT Name FROM customer WHERE Customer_ID= ?",id);
        if (resultSet.next()){
        return resultSet.getString(1);

        }
                return  null;*/
