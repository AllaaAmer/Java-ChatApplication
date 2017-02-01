/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train1;

import DAO.User;
import Viewpkg.ViewController;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alaa
 */
public class FXMLRegistrationController implements Initializable {

    public ViewController mainController;
    @FXML
    ComboBox genderChooser;
    @FXML
    ComboBox countryChooser;
    @FXML
    Label output;
    @FXML 
    TextField firstName;
    @FXML 
    TextField lastName;
    @FXML 
    TextField email;
    public void setController(ViewController vc)
    {
        mainController=vc;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genderChooser.getItems().addAll(
                "Male",
                "Female"
        );
       // genderChooser.setEditable(true);
        countryChooser.getItems().addAll(
                "Egypt",
                "US",
                "German"
        );
       // countryChooser.setEditable(true);

    }

    @FXML
    void SignUpAction(ActionEvent event) {
        
        User newUser=new User();
        newUser.setfirstName("Nour");
        newUser.setlastName("Khaled");
        newUser.setBio("this is a new account");
        newUser.setBirthDate(new Date());
        newUser.setGender("f");
        newUser.setOffline(1);
        newUser.setCountry("Cairo");
        newUser.setStatus("available");
        newUser.setMail("nour@hotmail.com");
        newUser.setMobile(01142117735);
        if(mainController.signup(newUser))
            System.out.println("Added Successfully");
        else
            System.out.println("not added");
    }
    private boolean validateEmail()
    {
        return true;
    }
}
