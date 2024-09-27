package org.example.bo.custom.impl;

import com.lowagie.text.pdf.crypto.IVGenerator;
import org.example.bo.custom.ItemBO;
import org.example.dao.custom.impl.CustomerDAOImpl;
import org.example.dao.custom.impl.ItemDAOImpl;
import org.example.dto.ItemDTO;
import org.example.entity.Customer;
import org.example.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAOImpl itemDAO = new ItemDAOImpl();

    public boolean saveitem(ItemDTO item) {
        return itemDAO.save(new Item(item.getId(),item.getName(),item.getPrice(),item.getQty()));

    }

    @Override
    public ArrayList<ItemDTO> getAll() {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        List<Item> all = itemDAO.getAll();
        for (Item i:all){
            allItems.add(new ItemDTO(i.getId(),i.getName(),i.getPrice(),i.getQty()));

        }
        return allItems;
    }

    @Override
    public boolean updateitem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new ItemDTO(item.getId(),item.getName(),item.getPrice(),item.getQty()));
    }

    @Override
    public boolean deleteitem(String id) {
        return itemDAO.delete(id);
    }

    @Override
    public List<String> getIds() {
        return itemDAO.getIds();
    }

    @Override
    public ItemDTO searchById(String value) {
        Item e = itemDAO.getData(value);
        return new ItemDTO(e.getId(),e.getName(),e.getPrice(),e.getQty());
    }


}
