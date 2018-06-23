package com.trend.mooringcalculator.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

/**
 * Identifies a controller that will be created by an {@link FXMLLoader}. The
 * {@code FXMLLoader} will automatically inject {@code location} and
 * {@code resources} properties into the controller, and then it will call the
 * no-arg {@link #initialize()} method. This is the recommended approach: don't
 * use the {@link Initializable} interface.
 */
public interface FXMLController {

    /**
     * Called by the {@link FXMLLoader} to initialize a controller after its
     * root element has been completely processed. This means all of the
     * controller's {@link FXML} elements will be injected, and they can be used
     * to wire up the GUI in ways that couldn't be accomplished using pure FXML,
     * e.g. attaching property listeners.
     */
    void initialize();

}

//@Component
//public class FXMLController {
//
//    @FXML
//    private ListView<String> mainListView;
//
//    @FXML
//    private AnchorPane calculatorLayout;
//
//    /*List items to be set on ListView*/
//    final ObservableList<String> mainListViewItems = FXCollections.observableArrayList("Barge and quay data", "Enviromental data", "Mooring Points", "Mooring Lines");
//
//    @FXML
//    public void initialize() {
//        mainListView.setItems(mainListViewItems);
//        /*adding items to lisView on initialize*/
//    }
//
//
//    /**
//     * Handle click on item in ListView
//     */
//    @FXML
//    public void handleMouseClick(MouseEvent arg0) throws IOException {
//        System.out.println("clicked on " + mainListView.getSelectionModel().getSelectedItem());
//
//        String clickedItem = mainListView.getSelectionModel().getSelectedItem();
//        /*get string of clicked item*/
//        String fxmlSrc = null;
//        if ("Barge and quay data".equals(clickedItem)) {
//            System.out.println("kliknales 1");
//            fxmlSrc = "/fxml/BargeDataLayout.fxml";
//        } else if ("Enviromental data".equals(clickedItem)) {
//            fxmlSrc = "/fxml/EnviromentalDataLayout.fxml";
//        } else if ("Mooring Points".equals(clickedItem)) {
//            fxmlSrc = "/fxml/MooringPointsLayout.fxml";
//        } else if ("Mooring Lines".equals(clickedItem)) {
//            fxmlSrc = "/fxml/MooringLinesLayout.fxml";
//        }
//
//        AnchorPane pane = FXMLLoader.load(getClass().getResource(fxmlSrc));
//        /*loading new scene*/
//        
//        calculatorLayout.getChildren().setAll(pane);
//        
//    }
//    
//
//    
////    @Autowired
////    public BargeRepository bargeRepository;
//
//}
