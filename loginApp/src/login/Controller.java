package login;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML
    private Pane innerPane;

    @FXML
    private TextField txtbox1;

    @FXML
    private PasswordField pswdbox1;

    @FXML
    private JFXButton btn1;

    @FXML
    private Label rsLabel;

    @FXML
    public void clicked(ActionEvent actionEvent){
        if(txtbox1.getText().equals("fuadik88") && pswdbox1.getText().equals("rembo")){
            rsLabel.setText("Succesfully LogON!");
        }else rsLabel.setText("Incorrect Username or Password!");
    }

}