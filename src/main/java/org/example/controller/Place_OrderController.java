package org.example.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBO;
import org.example.bo.custom.PlaceOrderBO;
import org.example.bo.custom.impl.ItemBOImpl;
import org.example.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public class Place_OrderController {
    public TextField txtId;
    public JFXComboBox<String> cmbCustomerId;
    public JFXComboBox<String> cmbItemId;
    public TextField txtQty;
    public JFXComboBox<String> cmbPAymentMethod;
    public Label lName;
    public Label lUnitPrice;
    public Label lQtyOnHand;
    public Label netTotlelbl;
    public TableView tblOrderCart;
    public TableColumn<?, ?> colItemId;
    public TableColumn<?, ?> colName;
    public TableColumn<?, ?> colqty;
    public TableColumn<?, ?> colPrice;
    public TableColumn<?, ?> colTotal;
    public Label lCustomerName;
    ItemBOImpl itemBO = (ItemBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PO);

    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
       setCmbCustomerId();
          setCmbItemId();
        setPaymentMethodtype();
    }


    public void idtextKeyReleased(KeyEvent keyEvent) {
    }

/*
    public void btnPlaceOrderOnAction(ActionEvent event) {
        int qtyOnHand = Integer.parseInt(lQtyOnHand.getText());
        int qtyy = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(lUnitPrice.getText());
        String oid = txtId.getText();
        String iid = cmbItemId.getValue();
        String cid = cmbCustomerId.getValue();
        String des = lName.getAccessibleHelp();

        double tot = qtyy*price;
        System.out.println(tot);




        placeOrderBO.placeOrder(cid,oid,iid,price,qtyy,tot,des,qtyOnHand, qtyy);
    }
*/

    private void setCellValueFactory() {
        colItemId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void getCustomerName() {
        String id = cmbCustomerId.getValue();
        String name = customerBO.getName(id);


        lCustomerName.setText(name);

    }

    private void setCmbCustomerId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> customerList = customerBO.getIds();

        for (String customer : customerList) {
            obList.add(customer);
        }
        cmbCustomerId.setItems(obList);
    }

    private void setCmbItemId() throws SQLException, ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> itemList = itemBO.getIds();

        for (String item : itemList) {
            obList.add(item);
        }
        cmbItemId.setItems(obList);

    }

    public void customerCmbOnAction(ActionEvent event) {
        getCustomerName();
    }

    private void setPaymentMethodtype() {
        ObservableList<String> paymentmethod = FXCollections.observableArrayList(
                "Cash", "Credit Card", "Debit Card", "Check"
        );
        cmbPAymentMethod.setItems(paymentmethod);
    }

    public void itemCmbOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        ItemDTO item = itemBO.searchById(cmbItemId.getValue());

        lName.setText(item.getName());
        lUnitPrice.setText(item.getPrice());
        lQtyOnHand.setText(item.getQty());
    }

    public void btnPlaceOrderOnAction(ActionEvent event) {
    }
}
