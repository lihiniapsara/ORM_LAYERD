package org.example.dao.custom;

import org.example.dao.SuperDAO;
import org.example.dto.ItemDTO;
import org.example.entity.Item;

import java.sql.SQLException;

public interface ItemDAO extends SuperDAO {
    boolean update(ItemDTO item) throws SQLException, ClassNotFoundException;

    boolean update(Item item);
}
