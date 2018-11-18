package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.tree.ExpandVetoException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class waitingRoomController implements Initializable {
    public Label statusLabel;
    public Counter impl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setInterface(Counter impl){
        this.impl=impl;
    }
    public void waitForOtherPlayer(int sessiontoken){
        try{
            System.out.println(sessiontoken+impl.toString());
            while(!impl.vindtTegenspeler(sessiontoken)){
                try{
                Thread.sleep(1000);
                    System.out.println("sleept");

                }
                catch (Exception e){
                    System.out.println("cought");
                }
            }
            System.out.println("game started");
            FXMLLoader Loader=new FXMLLoader();
            Loader.setLocation(getClass().getResource("gameWindow.fxml"));
            try{
                Loader.load();
            }
            catch (Exception e){
                System.out.println("failed");
            }

            Stage stage=new Stage();
            GameWindowController controller =Loader.getController();
            /*LogInController controller =Loader.getController();
            controller.setInterface(impl);*/
            //controller.setGame(sessiontoken);
            controller.setInterface(impl);
            controller.setHelper(new ListenerHelper(controller,impl,sessiontoken));
            Parent root=Loader.getRoot();
            stage.setTitle("Game");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();
            Stage oldstage  = (Stage) statusLabel.getScene().getWindow();
            oldstage.close();

            controller.setGame(sessiontoken);




        }
        catch (Exception e){

        }

    }
}
