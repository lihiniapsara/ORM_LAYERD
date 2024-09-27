package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import org.example.bo.BOFactory;
import org.example.bo.custom.impl.ItemBOImpl;
import org.example.dto.CustomerDTO;
import org.example.dto.ItemDTO;
import org.example.tm.CustomerTm;
import org.example.tm.ItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtPrice;
    public TextField txtQty;
    public TableView<ItemTm> tblItem;
    public TableColumn<?,?> colId;
    public TableColumn<?,?> colName;
    public TableColumn<?,?> colPrice;
    public TableColumn<?,?> colQty;
    public Text title;

    ItemBOImpl itemBO = (ItemBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);
    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadAllCustomers();
    }
    private void loadAllCustomers() {
        ObservableList<ItemTm> obList = FXCollections.observableArrayList();

        ArrayList<ItemDTO> itemDTOS = itemBO.getAll();
        for (ItemDTO item : itemDTOS) {
            obList.add(new ItemTm(item.getId(), item.getName(), item.getPrice(), item.getQty()));

        }

        tblItem.setItems(obList);
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }
    public void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String price = txtPrice.getText();
        String qty = txtQty.getText();

        boolean isSaved = itemBO.saveitem(new ItemDTO(id, name, price, qty));
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "item saved!").show();

        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save item!").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String price = txtPrice.getText();
        String qty = txtQty.getText();

        boolean isUpdated = itemBO.updateitem(new ItemDTO(id,name,price,qty));
        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"item updated!");
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed to save item!").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        boolean isSaved = itemBO.deleteitem(id);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "item delete!").show();

        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save delete!").show();
        }
    }

    public void idtextKeyReleased(KeyEvent keyEvent) {
    }

    public void nametextKeyReleased(KeyEvent keyEvent) {
    }

    public void pricetextKeyReleased(KeyEvent keyEvent) {
    }

    public void qtytextKeyReleased(KeyEvent keyEvent) {
    }
}
