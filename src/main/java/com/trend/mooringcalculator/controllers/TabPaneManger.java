package com.trend.mooringcalculator.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TabPaneManger implements FXMLController{

    private final BargeTabController bargeTabController;
   private final CargoEnvTabController cargoEnvTabController;
   private final ForcesTabController forcesTabController;
    @FXML  private Tab bargeTab; 
    @FXML  private Tab cargoEnvTab;
    @FXML private Tab forcesTab;

    @Autowired
    public TabPaneManger(BargeTabController bargeTabController, CargoEnvTabController cargoEnvTabController, ForcesTabController forcesTabController) {
        this.bargeTabController = bargeTabController;
        this.cargoEnvTabController = cargoEnvTabController;
        this.forcesTabController = forcesTabController;
    }
    
    @Override
    public void initialize() {
    }

    public BargeTabController getBargeTabController() {
        return bargeTabController;
    }

    public CargoEnvTabController getCargoEnvTabController() {
        return cargoEnvTabController;
    }
    public ForcesTabController getForcesTabController(){
        return forcesTabController;
    }
}