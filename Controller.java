package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Label helloWorld;
    public TextField username;
    public PasswordField password;
    public Label statuslabel;
    public Counter impl;
    public Button testbutton;
    private int sessiontoken;

    public TextField SignInUsername;
    public TextField SignInWW1;
    public TextField SignInWW2;
    public Label warningLabel;

    public void sayHelloWorld(ActionEvent actionEvent){
        helloWorld.setText("Hello world");
    }

    public void setToken(int i){
        sessiontoken=i;
    }

    public void OpeningGame(){

    }
    public void buttonTest(ActionEvent ae){
        testbutton.setText("veranderd");

    }
    public void checkLogin(ActionEvent actionEvent){

    }
    public void setInterface(Counter impl){
        this.impl=impl;
    }
    public void LoginScherm(){
        try {

            /*Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
// search for CounterService
            impl = (Counter) myRegistry.lookup("Login");

*/
            impl.testConnectie();

            System.out.println("loginscherm");
            FXMLLoader Loader=new FXMLLoader();
            Loader.setLocation(getClass().getResource("logIn.fxml"));
            try{
                Loader.load();
            }
            catch (IOException ioe){
            }

            Stage stage=new Stage();
            LogInController controller =Loader.getController();
            controller.setInterface(impl);
            Parent root=Loader.getRoot();
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();


        }
        catch (Exception e){

        }

    }
    public void tempGame(){
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("gameWindow.fxml"));
        try{
            Loader.load();
        }
        catch (IOException ioe){

        }
        Stage stage=new Stage();
        GameWindowController controller =Loader.getController();
        Parent root=Loader.getRoot();
        stage.setTitle("game");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }
    public void SignInscherm(){
        try {
            /*if(impl==null) {
                Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
                // search for CounterService
                impl = (Counter) myRegistry.lookup("Login");
            }*/
            impl.testConnectie();


            FXMLLoader Loader=new FXMLLoader();
            Loader.setLocation(getClass().getResource("signIn.fxml"));
            try{
                Loader.load();
            }
            catch (IOException ioe){

            }
            Stage stage=new Stage();
            SignInController controller =Loader.getController();
            controller.setInterface(impl);
            Parent root=Loader.getRoot();
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();

            /*System.out.println("hier");
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();*/



        }
        catch (Exception e){
            System.out.println("signinscherm exception");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
