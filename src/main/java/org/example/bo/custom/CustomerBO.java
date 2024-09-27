package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO extends SuperBO {

    public boolean savecustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException ;


    ArrayList<CustomerDTO> getAll();

    boolean updatecustomer(CustomerDTO customerDTO);

    boolean deletecustomer(String tel);

    String getName(String id);

    List<String> getIds();
}
