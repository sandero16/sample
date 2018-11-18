package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    public TextField username;
    public PasswordField password;
    public Label label;
    public Counter impl;

    public void setInterface(Counter impl){
        this.impl=impl;
    }

    public void sendLogin(){
        try {

            String name = username.getText();
            String ww = password.getText();
            int sessiontoken=impl.LogIn(name, ww);
            System.out.println("token"+(sessiontoken+1));
            int i=9;
            if (sessiontoken!=-1) {
                PrintWriter writer = new PrintWriter("sessiontoken.txt");
                writer.write(i);
                writer.close();
                //dit kan eigenlijk ook al gebeuren direct na het inloggen, momenteel beschouwen dit
                // als apparte functie
                /*
                impl.NewPlayer(sessiontoken);
                //speler tonen
                //start spel
                while(!impl.zoekAnderespeler(sessiontoken)){
                }

                */

                //TODO thread starten die luistert of game vol is
                //TODO testen of wanneer speler 1 knop één drukt speler 2 dit ook kan zienfs

                FXMLLoader Loader=new FXMLLoader();
                Loader.setLocation(getClass().getResource("waitingRoom.fxml"));
                try{
                    Loader.load();
                }
                catch (IOException ioe){
                }

                Stage stage=new Stage();
                waitingRoomController controller =Loader.getController();
                controller.setInterface(impl);
                Parent root=Loader.getRoot();
                stage.setTitle("waitingroom");
                stage.setScene(new Scene(root, 300, 275));
                stage.show();


                Stage oldstage  = (Stage) username.getScene().getWindow();
                oldstage.close();
                controller.waitForOtherPlayer(sessiontoken);

                System.out.println("ik ben er nog");
            }
            else{
                label.setText("wachtwoord is fout");
                System.out.println("wachtwoord is fout");
                System.out.println(impl.geefWW(name));
            }
        }
        catch (Exception e){

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
