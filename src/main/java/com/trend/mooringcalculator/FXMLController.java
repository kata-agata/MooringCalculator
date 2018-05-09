package com.trend.mooringcalculator;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class FXMLController {

    @FXML
    private ListView<String> mainListView;

    @FXML
    private AnchorPane calculatorLayout;

    /*List items to be set on ListView*/
    final ObservableList<String> mainListViewItems = FXCollections.observableArrayList("Barge and quay data", "Enviromental data", "Mooring Points", "Mooring Lines");

    @FXML
    public void initialize() {
        mainListView.setItems(mainListViewItems); /*adding items to lisView on initialize*/
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/BargeDataLayout.fxml"));
        calculatorLayout.getChildren().setAll(pane);
    } /*test loading new fxml file into scene*/

    
    /**********************Handle click on item in ListView **************************/
    @FXML
    public void handleMouseClick(MouseEvent arg0) throws IOException { 
        System.out.println("clicked on " + mainListView.getSelectionModel().getSelectedItem());

        String clickedItem = mainListView.getSelectionModel().getSelectedItem(); /*get string of clicked item*/
        if ("Barge and quay data".equals(clickedItem)) {
            System.out.println("kliknales 1");
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/BargeDataLayout.fxml")); /*loading new scene*/
            calculatorLayout.getChildren().setAll(pane);
        }
    }

}
