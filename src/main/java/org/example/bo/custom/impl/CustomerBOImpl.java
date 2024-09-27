package org.example.bo.custom.impl;

import org.example.bo.custom.CustomerBO;
import org.example.dao.custom.impl.CustomerDAOImpl;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerBOImpl implements CustomerBO {
    CustomerDAOImpl customerDAO = new CustomerDAOImpl();


    public boolean savecustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(customer.getId(),customer.getName(),customer.getAddress(),customer.getTel()));
    }

    public ArrayList<CustomerDTO> getAll() {
        ArrayList<CustomerDTO> allCustomers= new ArrayList<>();
        List<Customer> all = customerDAO.getAll();
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getId(),
                    c.getName(),
                    c.getAddress(),
                    c.getTel())
            );
        }
        return allCustomers;    }

    @Override
    public boolean updatecustomer(CustomerDTO customer) {
        return customerDAO.update(new Customer(customer.getId(),customer.getName(),customer.getAddress(),customer.getTel()));
    }
    @Override
    public boolean deletecustomer(String tel) {
        return customerDAO.delete(tel);
    }
    @Override
    public String getName(String id) {
        return customerDAO.getName(id);
    }

    @Override
    public List<String> getIds() {
        return customerDAO.getIds();
    }

}
