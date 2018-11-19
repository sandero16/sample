package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

public class eindeSpelController implements Initializable {
    public Counter impl;
    public int sessiontoken;
    public Label status;
    public Label score1;
    public Label score2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void getResults(Counter impl, int sessiontoken, int score){
        try {
            if(impl.getResult(sessiontoken)){
                status.setText("Je hebt gewonnen");
            }
            else {
                status.setText("Je bent verloren");
            }
            score1.setText("jouw score: "+Integer.toString(score));
            score2.setText("speler 2 zijn score: "+impl.getScore(sessiontoken));
        }
        catch (Exception e){

        }
    }
}
