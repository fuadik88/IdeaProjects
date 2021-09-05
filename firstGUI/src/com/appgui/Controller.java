package com.appgui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private JFXButton fxBtn1;

    @FXML
    private Button fxBtn2;

    @FXML
    private JFXListView<String> fxListVieW;

    @FXML
    private CheckBox fxCheckBox1;

    @FXML
    private JFXTextArea fxTxtArea;

    @FXML
    void initialize() {
        fxBtn2.setDisable(true);
        fxListVieW.getItems().addAll("Engine", "Tiers", "Radio", "Controller", "FuelTank");
        fxListVieW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private String generate(){
        String pull="";
        ObservableList<String> list = fxListVieW.getSelectionModel().getSelectedItems();

        for(String r : list){
            pull += r + "\n";
        }
        return pull;
    }

    public void clicked(ActionEvent actionEvent) {
        fxTxtArea.setText(generate());
    }
    @FXML
    void disableList(ActionEvent actionEvent) {
        if (fxCheckBox1.isSelected()) {
            fxListVieW.getSelectionModel().select(-1);
            fxListVieW.setDisable(true);
            fxTxtArea.setText("");
        } else fxListVieW.setDisable(false);
    }
}
