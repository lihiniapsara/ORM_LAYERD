package org.example.dao.custom;

import org.example.dao.SuperDAO;
import org.example.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends SuperDAO {
    Customer getdata(String cid);

/*
    public List<String> getIds() throws SQLException, ClassNotFoundException;
*/

}
