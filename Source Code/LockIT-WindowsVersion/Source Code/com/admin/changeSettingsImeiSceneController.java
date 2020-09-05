package com.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class changeSettingsImeiSceneController implements Initializable  {
    @FXML
    Button newBtn,resetBtn,aboutBtn,changeBtn,changeSettingsChangePasswordBtn,changeSettingsChangeImeiBtn,changeSettingsChangePeriodBtn,imeiLockBtn;
    @FXML
    TextField password,imei;
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
        changeSettingsChangePasswordBtn.setOnAction(e->{
            Stage passwordBtnStage = (Stage) changeSettingsChangePasswordBtn.getScene().getWindow();
            try {
                Parent passwordBtnScene = FXMLLoader.load(getClass().getResource("changeSettingsPassword.fxml"));
                passwordBtnStage.setScene(new Scene(passwordBtnScene));
            }
            catch (IOException ex){
            }
        });
        changeSettingsChangeImeiBtn.setOnAction(e->{
            Stage imeiBtnStage = (Stage) changeSettingsChangeImeiBtn.getScene().getWindow();
            try {
                Parent imeiBtnScene = FXMLLoader.load(getClass().getResource("changeSettingsImei.fxml"));
                imeiBtnStage.setScene(new Scene(imeiBtnScene));
            }
            catch (IOException ex){
            }
        });
        changeSettingsChangePeriodBtn.setOnAction(e->{
            Stage periodBtnStage = (Stage) changeSettingsChangePeriodBtn.getScene().getWindow();
            try {
                Parent periodBtnScene = FXMLLoader.load(getClass().getResource("changeSettingsPeriod.fxml"));
                periodBtnStage.setScene(new Scene(periodBtnScene));
            }
            catch (IOException ex){
            }
        });
        imeiLockBtn.setOnAction(e->{
            String Pass=password.getText();
            String newimei=imei.getText();
          //Data retrieval
            Object o[]= com.windowLock.RetrieveData.retrieveData();
            String retreivedPassword=(String) o[0];

            int retreivedPeriod=(int) o[2];
            if(Pass.length()>=1&&Pass.equals(retreivedPassword))
            {
            	try {
            		Long.parseLong(newimei);
            		if(!(newimei.length()>10))
            			throw new NumberFormatException();
            		
                    WriteData.writeData(newimei, Pass, retreivedPeriod);
            		 ButtonType b1 = new ButtonType("Ok");
  		           Alert success=new Alert(Alert.AlertType.INFORMATION,"Action Successfull",b1);
  		           
  		          ((Stage)success.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));
  		           success.setTitle("Success");
  		           success.setHeaderText("Details Saved");
  		           success.initModality(Modality.APPLICATION_MODAL);
  		           success.setResizable(false);
  		           ImageView ii=new ImageView(this.getClass().getResource("success.png").toString());
  		           ii.setFitHeight(50);
  		           ii.setFitWidth(95);
  		           success.getDialogPane().setGraphic(ii);
  		           success.show();
                	}
            	catch(NumberFormatException ex) {
            		ButtonType b1 = new ButtonType("Ok");
    		           Alert exit=new Alert(Alert.AlertType.WARNING,"Type valid IMEI number",b1);
    		          ((Stage)exit.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));
    		           exit.setTitle("Warning");
    		           exit.initModality(Modality.APPLICATION_MODAL);
    		           exit.setResizable(false);
    		           exit.show();
                }
            }
            else
            {
            	   ButtonType b1 = new ButtonType("Ok");
		           Alert exit=new Alert(Alert.AlertType.ERROR,"Wrong backup Password",b1);
		          ((Stage)exit.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));
		           exit.setTitle("Error");
		           exit.initModality(Modality.APPLICATION_MODAL);
		           exit.setResizable(false);
		           exit.show();
            }    		
            

          
        });
    }
}

