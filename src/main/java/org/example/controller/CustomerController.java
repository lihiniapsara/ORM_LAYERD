package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBO;
import org.example.dto.CustomerDTO;
import org.example.tm.CustomerTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<CustomerTm> tblCustomer;


    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;
    CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadAllCustomers();
    }
    @FXML
    void addresstextKeyReleased(KeyEvent event) {

    }


    private void loadAllCustomers() {
        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        ArrayList<CustomerDTO> customerList = customerBO.getAll();
        for (CustomerDTO customer : customerList) {
            obList.add(new CustomerTm(customer.getId(), customer.getName(), customer.getAddress(), customer.getTel()));

        }

        tblCustomer.setItems(obList);
    }
    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }
    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

            boolean isSaved = customerBO.savecustomer(new CustomerDTO(id, name, address, tel));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();

            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save customer!").show();
            }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();
        try {
            boolean isUpdated = customerBO.updatecustomer(new CustomerDTO(id, name, address, tel));
            if (isUpdated) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        }catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws ClassNotFoundException {
        String tel = txtTel.getText();
        try {
            boolean isDeleled =customerBO.deletecustomer(tel);
            if (isDeleled){
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION,"customer deleted!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"customer not deleted!");
        }

    }
    @FXML
    void idtextKeyReleased(KeyEvent event) {

    }

    @FXML
    void nametextKeyReleased(KeyEvent event) {

    }

    @FXML
    void teltextKeyReleased(KeyEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
