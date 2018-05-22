/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trend.mooringcalculator;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author agataj
 */
public class BargeController {

    @FXML
    private TextField bargeName;

    @FXML
    private TextField bargeLength;

    @FXML
    private TextField bargeBeam;

    @FXML
    private TextField bargeHeight;

    @FXML
    private TextField bargeTrim;

    @FXML
    private Button confirmBarge;

    @FXML
    private void bargeDataConfirm(ActionEvent actionEvent) {

        if (bargeName.getText() != null && !bargeName.getText().isEmpty()) {
            /*check if bargeName is set*/
            System.out.println(bargeName.getText());
        }

    }

    @FXML
    public void initialize() {

        /*Bind observing dependencies for changes
        *when all textfileds of barge data are filled the button is enabled
         */
        confirmBarge.disableProperty().bind(
                Bindings.isEmpty(bargeName.textProperty())
                .or(Bindings.isEmpty(bargeLength.textProperty()))
                .or(Bindings.isEmpty(bargeBeam.textProperty()))
                .or(Bindings.isEmpty(bargeHeight.textProperty()))
                .or(Bindings.isEmpty(bargeTrim.textProperty()))
        );
    }
}
