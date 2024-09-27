package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.ItemDAO;
import org.example.dto.ItemDTO;
import org.example.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {




    public boolean save(Item entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }
    public List<Item> getAll() {

        Session session = FactoryConfiguration.getInstance().getSession();
        Query<Item> query = session.createQuery("from Item", Item.class);
        List<Item> items = query.list();
        session.close();

        return items;
    }
    public boolean update(ItemDTO item) {


        return false;
    }

    @Override
    public boolean update(Item item) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(item);

        transaction.commit();
        session.close();

        return true;    }


    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Item WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);

        Item item = (Item) query.uniqueResult();


        if (item != null) {
            session.delete(item);
            transaction.commit();
        }
        session.close();

        return item != null;
    }


    public List<String> getIds() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<String> query = session.createNativeQuery("select ID from Item");
        List<String> clist = query.list();
        session.close();
        return clist;
    }

    public Item getData(String value) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<Item> query = session.createQuery("from Item where id =:id ").setParameter("id",value);
        Item item = query.getSingleResult();
        session.close();

        return item;
    }
}
