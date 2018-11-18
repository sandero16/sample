package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    public TextField SignInUsername;
    public TextField SignInWW1;
    public TextField SignInWW2;
    public Counter impl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setInterface(Counter impl){
        this.impl=impl;
    }
    public void sendSignIn(){
        try {
            String name=SignInUsername.getText();
            String signInww=SignInWW1.getText();
            String signInww2=SignInWW2.getText();
            System.out.println(name+" " +signInww+" "+signInww2);

            while(!signInww.equals(signInww2)){
             //   warningLabel.setText("ww zijn niet identiek");
            }
            //methode schrijven die duplicats ziet;

            impl.SignIn(name, signInww);

            Stage stage  = (Stage) SignInUsername.getScene().getWindow();
            stage.close();
        }
        catch (Exception e){
            System.out.println("error");
        }
    }
}
