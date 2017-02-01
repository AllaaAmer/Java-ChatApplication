/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewpkg;

import Controllerpkg.Controller;
import DAO.ConfigurationInfo;
import DAO.User;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import train1.FXMLRegistrationController;


/**
 *
 * @author Nour
 */
public class ViewController extends Application {

    Controller clientController;

    public ViewController() {
        clientController = new Controller(this);
    }

    @Override
    public void start(Stage primaryStage) {
        
        //boolean c=connect();
        //if(c) //connected to server
        {
            FXMLLoader signuploader=new FXMLLoader();
            try {
                Parent root=signuploader.load(getClass().getResource("..//train1//FXML-Registration.fxml").openStream());
                FXMLRegistrationController signupControl=signuploader.getController();
                signupControl.setController(this);
                Scene sc=new Scene(root);
                primaryStage.setScene(sc);
            } catch (IOException ex) {
                Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           primaryStage.show(); 
        }
    }
    
    public boolean signup(User u)
    {
       return clientController.SignUp(u);
    }
    private boolean connect()
    {
        Dialog<ConfigurationInfo> dialog = new Dialog<>();
        dialog.setTitle("Server Information");
        dialog.setHeaderText("");
        dialog.setResizable(true);
        Label label1 = new Label("IP Address: ");
        Label label2 = new Label("Port: ");
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(text1, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(text2, 2, 2);
        dialog.getDialogPane().setContent(grid);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        dialog.setResultConverter(new Callback<ButtonType, ConfigurationInfo>() {
            @Override
            public ConfigurationInfo call(ButtonType b) {
                if (b == buttonTypeOk) {
                    return new ConfigurationInfo(text1.getText(),Integer.parseInt(text2.getText()));
                }
                return null;
            }
        });
        Optional<ConfigurationInfo> result = dialog.showAndWait();
        if(result!=null){
            return clientController.connectToServer(result.get());
        }
        else
            return false;
    }
}
