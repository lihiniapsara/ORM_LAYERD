package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.ItemDTO;
import org.example.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemBO extends SuperBO {
    public boolean saveitem(ItemDTO item) ;

    ArrayList<ItemDTO> getAll();

    boolean updateitem(ItemDTO item) throws SQLException, ClassNotFoundException;

    boolean deleteitem(String id);


    List<String> getIds();

    ItemDTO searchById(String value);
}
