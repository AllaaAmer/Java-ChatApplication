///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package train1;
//
//import DAO.User;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//import javafx.collections.ObservableList;
//import javafx.event.Event;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//import javafx.scene.control.SelectionMode;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.shape.Circle;
//import javafx.util.Callback;
//
///**
// *
// * @author alaa
// */
//public class FXMLDocumentController implements Initializable {
//
//    @FXML
//    ListView<User> listViewOfFriends;
//
//    List<User> listOfFriends;
//    
//    @FXML 
//    Button button;
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//         button.setAlignment(Pos.CENTER_RIGHT);
//
//        listOfFriends = new ArrayList<User>();
//        listOfFriends.add(new User("allaa"));
//        listOfFriends.add(new User("ahmed"));
//        listOfFriends.add(new User("abas"));
//        listOfFriends.add(new User("mohamed"));
//        listOfFriends.add(new User("amer"));
//
//        listViewOfFriends.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
//            @Override
//            public ListCell<User> call(ListView<User> param) {
//                return new ListCell<User>() {
//                    FlowPane pane = new FlowPane();
//
//                    @Override
//                    protected void updateItem(User item, boolean empty) {
//                        super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
//
//                        if (item != null && !empty) {
//                            Label name = new Label();
//                            ImageView imagView = new ImageView(new Image(getClass().getResourceAsStream("bg.jpg")));
//                            imagView.setFitHeight(60);
//                            imagView.setFitWidth(60);
//                            Circle clip = new Circle(20,20,20);
//                            imagView.setClip(clip);
//                            
//                            name.setText(item.getfName());
//                            pane.getStyleClass().add("node");
//                            
//                            
//                            
//                            pane.getChildren().addAll(imagView,name);
//                            setGraphic(pane);
//                        } else {
//                            setGraphic(null);
//                        }
//                    }
//
//                };
//            }
//        });
//
//        listViewOfFriends.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//
//        listViewOfFriends.setOnMouseClicked(new EventHandler<Event>() {
//            @Override
//            public void handle(Event event) {
//                ObservableList<User> selectedItems = listViewOfFriends.getSelectionModel().getSelectedItems();
//
//                for (User s : selectedItems) {
//                    System.out.println("selected item " + s.getfName());
//                }
//            }
//
//        });
//
//        listViewOfFriends.getItems().setAll(listOfFriends);
//   }
//
//}
