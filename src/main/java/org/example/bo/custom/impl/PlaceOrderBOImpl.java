package org.example.bo.custom.impl;

import org.example.bo.custom.PlaceOrderBO;
import org.example.config.FactoryConfiguration;
import org.example.dao.DAOFactory;
import org.example.dao.custom.CustomerDAO;
import org.example.dao.custom.ItemDAO;
import org.example.dao.custom.OrderDAO;
import org.example.entity.Customer;
import org.example.entity.Item;
import org.example.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);


    @Override
    public void placeOrder(String cid, String oid, String iid, double price, int qtyy, double tot, String des, int qtyOnHand) {
       /* Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = customerDAO.getdata(cid);
        List<Customer>customers = new ArrayList<>();
        customers.add(customer);

        Order orders = new Order(oid, tot, qtyy, customer);
        System.out.println("order ek hadagththa");

        Item item = new Item(iid, des, price, (qty-qtyy));

        //many to many nisa list eka get karan  ethnin ekkt add k
        orders.getItem().add(item);
        // ekt adala item eketh list eka aran ekma kra
        item.getOrders().add(item);


        //transaction part
        try{
            boolean isSaved = orderDAO.save(orders);
            System.out.println(isSaved+"palaweni eka");
            System.out.println("order eka save");

            if (isSaved){
                boolean issaved2 = itemDAO.update(item);
                System.out.println(issaved2+"dewani eka");
                System.out.println("item ekath save");
                transaction.commit();
            }else {
                transaction.rollback();
            }
        }catch (Exception e){
            transaction.rollback();
        }
        finally {
            session.close();
        }*/
    }
}