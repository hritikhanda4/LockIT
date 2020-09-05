package com.windowLock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowLockGUI  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("windowLockFXML.fxml"));
        new Button().setStyle("");
        //For Shutdown when any wrong behaviour caught
        KeyboardHook kbhook = new KeyboardHook();
        new Thread(kbhook).start();
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        
        
        //Removing close minimize buttons
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("LockIt-Windows Lock");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
