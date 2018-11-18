package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
           /* if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }*/
// fire to localhost port 1099
            //System.setProperty("java.security.policy","file:./RMIpolicy.policy");
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
// search for CounterService
            Counter impl= (Counter) myRegistry.lookup("Login");


           /* impl.SignIn("Sandero","ww");
            if(impl.LogIn("Sandero", "ww")){
                System.out.println("juist");
            }
            if(impl.LogIn("Sandero", "wfdk")){
                System.out.println("fout");
            }
            //Counter impl = (Counter) myRegistry.lookup("Login");
            System.out.println("working");*/





            /*String name=username.getText();
            String ww=password.getText();
            System.out.println("name : "+name +" ww: "+ww);

            impl.SignIn("Sandero","aze");
            if(impl.LogIn("name",ww)){
                System.out.println("juist");
            }
            else{
                System.out.println("fout"+ " het juiste was: "+ impl.geefWW("Sandero"));
            }*/

        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("startWindow.fxml"));
        try{
            Loader.load();
        }
        catch (IOException ioe){

        }
        Controller controller =Loader.getController();
        controller.setInterface(impl);
        Parent root=Loader.getRoot();
        //Parent root = FXMLLoader.load(getClass().getResource("startWindow.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        launch(args);

    }
}
