import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBO;
import org.example.dto.CustomerDTO;
import org.example.tm.CustomerTm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer_Controller {

        public TableView tblCustomer;
        @FXML
        private TableColumn<?, ?> colAddress;

        @FXML
        private TableColumn<?, ?> colId;

        @FXML
        private TableColumn<?, ?> colName;

        @FXML
        private TableColumn<?, ?> colTel;
        @FXML
        public AnchorPane root;

        @FXML
        private javafx.scene.control.TextField txtAddress;

        @FXML
        private javafx.scene.control.TextField txtId;

        @FXML
        private javafx.scene.control.TextField txtName;

        @FXML
        private TextField txtTel;
    CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public void initialize() throws SQLException, ClassNotFoundException {
            setCellValueFactory();

        }

        private String generateNextOrderId(String currentId) {
            if(currentId != null) {
                String[] split = currentId.split("C");
                int idNum = Integer.parseInt(split[1]);
                return "C" + ++idNum;
            }
            return "C1";
        }
        private void setCellValueFactory() {
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        }
        @FXML
        public void btnClearOnAction(ActionEvent actionEvent) {
            clearFields();
        }

        private void clearFields() {
            txtId.setText("");
            txtName.setText("");
            txtAddress.setText("");
            txtTel.setText("");
        }
        @FXML
        public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String tel = txtTel.getText();

                try {
                    boolean isSaved = customerBO.savecustomer(new CustomerDTO(id, name, address, tel));
                    if (isSaved) {
                        new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                        initialize();
                        clearFields();
                    }
                    if (isSaved) {
                        new Alert(Alert.AlertType.INFORMATION, "Customer saved successfully!").show();
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Failed to save customer!").show();
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            clearFields();
        }
        @FXML
        public void btnUpdateOnAction(ActionEvent actionEvent) {

        }

        @FXML
        public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        }
        @FXML
        public void txtSearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        }

        public void nametextKeyReleased(KeyEvent keyEvent) {

        }

        public void teltextKeyReleased(KeyEvent keyEvent) {
        }

        public void addresstextKeyReleased(KeyEvent keyEvent) {
        }

        public void idtextKeyReleased(KeyEvent keyEvent) {
        }
    }




