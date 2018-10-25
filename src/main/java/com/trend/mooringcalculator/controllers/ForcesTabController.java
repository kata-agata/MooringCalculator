/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trend.mooringcalculator.controllers;

import com.trend.mooringcalculator.Barge;
import com.trend.mooringcalculator.WindAreaObject;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author agataj
 */
@Component
public class ForcesTabController implements Initializable {

    @FXML
    Label test;

    @FXML
    TableView<WindAreaObject> windTForceTableView;
    @FXML
    TableColumn<WindAreaObject, String> cargoNameColumnT;
    @FXML
    TableColumn<WindAreaObject, Double> cargoWindAreaColumnT, cargoShapeCoefColumnT, windForcePerpenColumn;

    @FXML
    TableView<WindAreaObject> windLForceTableView;
    @FXML
    TableColumn<WindAreaObject, String> cargoNameColumnL;
    @FXML
    TableColumn<WindAreaObject, Double> cargoWindAreaColumnL, cargoShapeCoefColumnL, windForceParaColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargoNameColumnT.setCellValueFactory(new PropertyValueFactory<WindAreaObject, String>("name"));
        cargoNameColumnL.setCellValueFactory(new PropertyValueFactory<WindAreaObject, String>("name"));
        cargoWindAreaColumnT.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("windAreaT"));
        cargoWindAreaColumnL.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("windAreaL"));
        cargoShapeCoefColumnT.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("shapeCoef"));
        cargoShapeCoefColumnL.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("shapeCoef"));
        windForcePerpenColumn.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("windForceT"));
        windForceParaColumn.setCellValueFactory(new PropertyValueFactory<WindAreaObject, Double>("windForceL"));
    }

    public void setwindForcesTableViews(ObservableList<WindAreaObject> cargos) {
        int sizeT = windTForceTableView.getItems().size();
        int sizeL = windLForceTableView.getItems().size();
        windTForceTableView.getItems().remove(1, sizeT);
        windTForceTableView.getItems().addAll(1, cargos);
        windLForceTableView.getItems().remove(1, sizeL);
        windLForceTableView.getItems().addAll(1, cargos);
    }

    public void addBargeWindForceObject(Barge barge) {
        WindAreaObject wao = barge;
        barge.setWindAreaL(barge.getBeam(), barge.getHeight(), barge.getDraught());
        barge.setWindAreaT(barge.getLength(), barge.getHeight(), barge.getDraught());
        if (windTForceTableView.hasProperties()) {
            windTForceTableView.getItems().set(0, wao);
        } else {
            windTForceTableView.getItems().add(wao);
        }
        if (windLForceTableView.hasProperties()) {
            windLForceTableView.getItems().set(0, wao);
        } else {
            windLForceTableView.getItems().add(wao);
        }
    }

    public void removeCargo(ObservableList<WindAreaObject> selected) {
        ObservableList<WindAreaObject> allCargosInTableT, allCargosInTableL;
        allCargosInTableT = windTForceTableView.getItems();
        allCargosInTableL = windLForceTableView.getItems();
        System.out.println("Selected" + selected.toString());
        selected.forEach(allCargosInTableT::remove);
                System.out.println("Selected2" + selected.toString());
        selected.forEach(allCargosInTableL::remove);
    }
    
    public void calculateWindForceT(Double vw,Double vc, Double hs){
        ObservableList<WindAreaObject> allCargosInTableT;
        allCargosInTableT=windTForceTableView.getItems();
        allCargosInTableT.forEach(wao -> wao.setWindForceT(vw, vc, hs));
//        for(WindAreaObject wao : allCargosInTableT){
//            System.out.println("ok");
//            System.out.println(wao.getName());
//        }
        allCargosInTableT.forEach(item->System.out.println(item.getWindForceT()));
        //windForcePerpenColumn.setCellFactory(value);
                
    }

}
