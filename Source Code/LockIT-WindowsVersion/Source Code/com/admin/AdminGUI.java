package com.admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class AdminGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	 Parent aboutLockIT= FXMLLoader.load(getClass().getResource("aboutLockIT.fxml"));



       primaryStage.setOnCloseRequest(event -> {
           event.consume();
           ButtonType b1 = new ButtonType("Yes");
           ButtonType b2 = new ButtonType("No");
           Alert exit=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure ?",b1,b2);
	       ((Stage)exit.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));

           exit.setTitle("Exit");
           exit.initModality(Modality.APPLICATION_MODAL);
           exit.setResizable(false);
           exit.show();
           exit.setOnCloseRequest(e->{
               if(exit.getResult().getText().equals("Yes"))
                   System.exit(0);
           });



       });
       primaryStage.getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));
       primaryStage.setResizable(false);

       Scene s=new Scene(aboutLockIT);
       //s.getStylesheets().add(getClass().getResource("adminGUI.css").toExternalForm());
       primaryStage.setTitle("Admin Panel-LockIT Windows Lock");
       primaryStage.setScene(s);
       primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
