/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trend.mooringcalculator.controllers;

import com.trend.mooringcalculator.Barge;
import com.trend.mooringcalculator.WindAreaObject;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author agataj
 */
@Component
public class BargeTabController {

    @FXML
    private TextField bargeName;

    @FXML
    private TextField bargeLength;

    @FXML
    private TextField bargeBeam;

    @FXML
    private TextField bargeHeight;

    @FXML
    private TextField bargeDraught;

    @FXML
    private Button confirmBarge;

    @FXML
    private Label formInfo;

    @FXML
    private ComboBox<String> mooringSide;

    @FXML
    private Label confirmedBargeName, confirmedLength, confirmedBeam, confirmedHeight, confirmedDraught;

    private final ForcesTabController forcesTabController;
  

    private final PseudoClass doubleErrorClass = PseudoClass.getPseudoClass("doubleError");
    /*PseudoClass to add style class for textfield when error occured*/

    private final ObservableList<String> mooringSideContentList = FXCollections.observableArrayList("Portside", "Starboard", "Aft", "Fore");

    @FXML
    private void bargeDataConfirm(ActionEvent actionEvent) {

        String name = bargeName.getText();
        Double beam = checkDouble(bargeBeam);
        /*check if double => if not returns 0*/
        Double length = checkDouble(bargeLength);
        Double height = checkDouble(bargeHeight);
        Double draught = checkDouble(bargeDraught);
        Double shape = 1.0;
        Barge barge = Barge.getInstance();
        barge.setName(name);
        barge.setLength(length);
        barge.setBeam(beam);
        barge.setHeight(height);
        barge.setDraught(draught);
        barge.setShapeCoef(shape);
        barge.setWindAreaL();
        barge.setWindAreaT();
        
//        Barge b = new Barge(name, length, beam, height, draught, shape);
        try {
            System.out.println("barge contoller");
            forcesTabController.setwindForcesTableViews(barge);
            
        } catch (Exception e) {
            e.getMessage();
        }
//        
//        if(beam>0 && length>0 && height>0 &&trim>0){
//          //  Barge barge= new Barge(name,length,beam,height,trim);
//            formInfo.setText("Correct data: " + barge.toString());
//            System.out.println(barge.toString());
//            
            confirmedBargeName.setText(name);
            confirmedLength.setText(length.toString());
            confirmedBeam.setText(beam.toString());
            confirmedHeight.setText(height.toString());
            confirmedDraught.setText(draught.toString());
//            
//        }else if (beam<0 && length<0 && height<0 &&trim<0) {
//            formInfo.setText("Please enter positive value");
//        }else{
//            formInfo.setText("Please insert number");
//        }
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
                .or(Bindings.isEmpty(bargeDraught.textProperty()))
        );

        mooringSide.setItems(mooringSideContentList);
            }

    /*
    *check if user type double in textfield
    *OK - turn off doubleErrorClass (red border of textField) and return input value
    *ERROR - turn on doubleErrorClass and return 0
     */
    private Double checkDouble(TextField tf) {
        Double valueToCheck = 0.0;
        try {
            valueToCheck = Double.parseDouble(tf.getText());
            tf.pseudoClassStateChanged(doubleErrorClass, false);
        } catch (NumberFormatException e) {
            System.out.println("This length is not a double");
            tf.pseudoClassStateChanged(doubleErrorClass, true);
        }
        return valueToCheck;
    }

    @Autowired
    public BargeTabController(ForcesTabController forcesTabController) {
        this.forcesTabController = forcesTabController;
    }


}
