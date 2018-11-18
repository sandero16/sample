package sample;

import javafx.application.Platform;

public class ListenerHelper implements Runnable {
    GameWindowController gameWindowController;
    Counter impl;
    int sessiontoken;


    public ListenerHelper(GameWindowController gameWindowController, Counter impl, int sessiontoken){
        this.gameWindowController=gameWindowController;
        this.impl=impl;
        this.sessiontoken=sessiontoken;


    }

    public void run(){
        try {
            while (!impl.checkBeurt(sessiontoken)) {
               // System.out.println("listening");
                //TODO null returnen als andere nog geen nieuwe keuze heeft gemaakt
                int[] gok = impl.getAndereGok(sessiontoken);
                if (gok != null) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            gameWindowController.incomingGok(gok);
                        }
                    });


                    int button = gok[0];
                    int waarde = gok[1];
                    System.out.println("button: " + button + " waarde: " + waarde);
                    Thread.sleep(800);
                }
            }

            gameWindowController.resetKeuzes();
            gameWindowController.setBeurt();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    gameWindowController.setLabel();
                }
            });

        }
        catch (Exception e){
    }
    }
}
