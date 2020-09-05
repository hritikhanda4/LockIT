package com.admin;
import com.admin.UserExist;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class aboutSceneController implements Initializable  {
    @FXML
    Button newBtn,resetBtn,aboutBtn,changeBtn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading data");
        newBtn.setOnAction(e->{
        	if(UserExist.isExist()) {
		           ButtonType b1 = new ButtonType("Ok");
		           Alert exit=new Alert(Alert.AlertType.WARNING,"User already exists, Either reset or change Allowed",b1);
		          ((Stage)exit.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));
		           exit.setTitle("Warning");
		           exit.initModality(Modality.APPLICATION_MODAL);
		           exit.setResizable(false);
		           exit.show();
		           

			}else {
            Stage newBtnStage = (Stage) newBtn.getScene().getWindow();
            try {
                Parent newScene = FXMLLoader.load(getClass().getResource("newScene.fxml"));
                newBtnStage.setScene(new Scene(newScene));
            }
            catch (IOException ex){
            }
			}});
        changeBtn.setOnAction(e->{
        	if(!UserExist.isExist()) {
        		 ButtonType b1 = new ButtonType("Ok");
		           Alert exit=new Alert(Alert.AlertType.WARNING,"No User exists, First Set New settings",b1);
		          ((Stage)exit.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));
		           exit.setTitle("Warning");
		           exit.initModality(Modality.APPLICATION_MODAL);
		           exit.setResizable(false);
		           exit.show();
        	}else {
            Stage changeBtnStage = (Stage) changeBtn.getScene().getWindow();
            try {
                Parent changePassScene = FXMLLoader.load(getClass().getResource("changeSettingsPassword.fxml"));
                changeBtnStage.setScene(new Scene(changePassScene));
            }
            catch (IOException ex){
            }
        	}
        });

        resetBtn.setOnAction(e->{
            		if(!UserExist.isExist()) {
    		           ButtonType b1 = new ButtonType("Ok");
    		           Alert exit=new Alert(Alert.AlertType.WARNING,"No User exists, First Set New settings",b1);
    		          ((Stage)exit.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));
    		           exit.setTitle("Warning");
    		           exit.initModality(Modality.APPLICATION_MODAL);
    		           exit.setResizable(false);
    		           exit.show();
    			}else {
            Stage resetBtnStage = (Stage) resetBtn.getScene().getWindow();
            try {
                Parent resetScene = FXMLLoader.load(getClass().getResource("resetAll.fxml"));
                resetBtnStage.setScene(new Scene(resetScene));
            }
            catch (IOException ex){
            }
        }
    	});
        aboutBtn.setOnAction(e->{
            Stage aboutBtnStage = (Stage) aboutBtn.getScene().getWindow();
            try {
                Parent aboutBtnScene = FXMLLoader.load(getClass().getResource("aboutLockIT.fxml"));
                aboutBtnStage.setScene(new Scene(aboutBtnScene));
            }
            catch (IOException ex){
            }
        });
    }
}

