/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trend.mooringcalculator.controllers;

import com.trend.mooringcalculator.Barge;
import com.trend.mooringcalculator.WindAreaObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author agataj
 */
@Component
public class CargoEnvTabController implements Initializable {

    @FXML
    private TableView<WindAreaObject> cargoTableView;

    @FXML
    private TableColumn<WindAreaObject, String> cargoNameColumn;

    @FXML
    private TableColumn<WindAreaObject, Double> cargoTAreaColumn;

    @FXML
    private TableColumn<WindAreaObject, Double> cargoLAreaColumn;

    @FXML
    private TableColumn<WindAreaObject, Double> cargoShapeCoefColumn;

    @FXML
    private TextField cargoName, cargoLArea, cargoTArea, cargoShapeCoef;

    @FXML
    Button confirmCargoEnv;
    
    @FXML
    private Label waterDensityLabel, airDensityLabel, gLabel;
    
    @FXML
    private  TextField vwTextField,vcTextField,hsTextField;
    
//    private final Double waterDensityValue = Double.parseDouble(waterDensity.getText());
//    private final Double airDensityValue = Double.parseDouble(airDensity.getText());
//    private final Double gValue = Double.parseDouble(g.getText());

    private final ForcesTabController forcesTabController;
    private ObservableList<WindAreaObject> cargos = FXCollections.observableArrayList();

    private Double waterDensity, airDensity, g, vw,vc,hs;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargoNameColumn.setCellValueFactory(new PropertyValueFactory<WindAreaObject, String>("name"));
        cargoTAreaColumn.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("windAreaT"));
        cargoLAreaColumn.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("windAreaL"));
        cargoShapeCoefColumn.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("shapeCoef"));
        cargoTableView.setItems(getCargo());

//        vw.textProperty().addListener((obs, oldText, newText) -> {
//        // do what you need with newText here, e.g.
//        forcesTabController.calculateWindForceT();
//        System.out.println(newText);
//    });
      
    }

    @FXML
    private void cargoDataAdd(ActionEvent actionEvent) {
        WindAreaObject cargo = new WindAreaObject();
        cargo.setName(cargoName.getText());
        cargo.setWindAreaL(Double.parseDouble(cargoLArea.getText()));
        cargo.setWindAreaT(Double.parseDouble(cargoTArea.getText()));
        cargo.setShapeCoef(Double.parseDouble(cargoShapeCoef.getText()));
        cargoTableView.getItems().add(cargo);
        cargos = cargoTableView.getItems();
        cargoName.clear();
        cargoLArea.clear();
        cargoTArea.clear();
        cargoShapeCoef.clear();
        waterDensity = Double.parseDouble(waterDensityLabel.getText());
        airDensity = Double.parseDouble(airDensityLabel.getText());
        vw = Double.parseDouble(vwTextField.getText());
        vc = Double.parseDouble(vcTextField.getText());
        hs = Double.parseDouble(hsTextField.getText());
        g = Double.parseDouble(gLabel.getText());
        try {
            System.out.println("ok");
            forcesTabController.setwindForcesTableViews(cargos, airDensity, vw,g);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @FXML
    private void cargoDataDelete(ActionEvent actionEvent) {
        ObservableList<WindAreaObject> cargoSelected, allCargos;
        allCargos = cargoTableView.getItems();
        cargoSelected = cargoTableView.getSelectionModel().getSelectedItems();
        forcesTabController.removeCargo(cargoSelected);
        cargoSelected.forEach(allCargos::remove);

    }

    public ObservableList<WindAreaObject> getCargo() {

        cargos.add(new WindAreaObject("STS", 859.00, 200.1, 1.2));
        cargos.add(new WindAreaObject("Bridge", 300.00, 249.0, 1.1));
        cargos.add(new WindAreaObject("MW", 99.0, 100.0, 1.7));
        return cargos;
    }
   

    @Autowired
    public CargoEnvTabController(ForcesTabController forcesTabController) {
        this.forcesTabController = forcesTabController;
    }
    
    

}
