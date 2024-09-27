package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.OrderDAO;
import org.example.entity.Item;
import org.example.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {
        boolean issaved = false;
        try{
            Session session= FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            issaved=true;
            session.close();

        }catch (Exception e){
            System.out.println("wade aulak");
        }
        return issaved;    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String tel) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
