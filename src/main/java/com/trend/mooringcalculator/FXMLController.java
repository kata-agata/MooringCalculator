package com.trend.mooringcalculator;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
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
        mainListView.setItems(mainListViewItems);
        /*adding items to lisView on initialize*/
    }


    /**
     * Handle click on item in ListView
     */
    @FXML
    public void handleMouseClick(MouseEvent arg0) throws IOException {
        System.out.println("clicked on " + mainListView.getSelectionModel().getSelectedItem());

        String clickedItem = mainListView.getSelectionModel().getSelectedItem();
        /*get string of clicked item*/
        String fxmlSrc = null;
        if ("Barge and quay data".equals(clickedItem)) {
            System.out.println("kliknales 1");
            fxmlSrc = "/fxml/BargeDataLayout.fxml";
        } else if ("Enviromental data".equals(clickedItem)) {
            fxmlSrc = "/fxml/EnviromentalDataLayout.fxml";
        } else if ("Mooring Points".equals(clickedItem)) {
            fxmlSrc = "/fxml/MooringPointsLayout.fxml";
        } else if ("Mooring Lines".equals(clickedItem)) {
            fxmlSrc = "/fxml/MooringLinesLayout.fxml";
        }

        AnchorPane pane = FXMLLoader.load(getClass().getResource(fxmlSrc));
        /*loading new scene*/
        
        calculatorLayout.getChildren().setAll(pane);
        
    }
    

    
//    @Autowired
//    public BargeRepository bargeRepository;

}
