package com.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class resetSceneController implements Initializable  {
    @FXML
    Button newBtn,resetBtn,aboutBtn,changeBtn,resetLockBtn;
    @FXML
    TextField oldPassword,newPassword,newImei;
    @FXML
    ChoiceBox<String> newPeriod;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading data");
        newPeriod.getItems().addAll("2","5","10","15","30");
        resetLockBtn.setOnAction(e->{

            String oldPass=oldPassword.getText();
            String newPass=newPassword.getText();
            String newImei1=newImei.getText();
            int newPeriod1=Integer.parseInt((String) newPeriod.getSelectionModel().getSelectedItem());
           
            //Data retrieval
            Object o[]= com.windowLock.RetrieveData.retrieveData();
            String retreivedPassword=(String) o[0];

            if(oldPass.length()>=1&&oldPass.equals(retreivedPassword))
            {
            	try {
            		Long.parseLong(newImei1);
            		if(!(newImei1.length()>10))
            			throw new NumberFormatException();
            		if(newPass.length()>=1) {
            			System.out.println("Submitting");
            			WriteData.writeData(newImei1, newPass, newPeriod1);
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
                	else {
                		ButtonType b1 = new ButtonType("Ok");
      		           Alert exit=new Alert(Alert.AlertType.WARNING,"Type valid Password",b1);
      		          ((Stage)exit.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));
      		           exit.setTitle("Warning");
      		           exit.initModality(Modality.APPLICATION_MODAL);
      		           exit.setResizable(false);
      		           exit.show();
                	}
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

