package com.windowLock;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.admin.AdminGUI;
import com.encrypting.DateTime;
import com.encrypting.ImeiRot13;
import com.encrypting.PasswordAscii;

public class Controller implements Initializable{
   @FXML
   Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30,btn31,btn32,btn33,btn34,btn35,btn36,btn37,btn38,btn39,btn40,btn41,btn42,btn43,btn44,btn45,btn46,btn47,btn48,btn49,btn50,btn51,btn52,btn53,btn54,btn55,btn56,btn57,btn58,btn59,btn60,btn61,btn62,btn63,btn64,btn65,btn66,btn67,btn68,btn69,btn70,btn71,btn72,btn73,btn74,btn75,btn76,btn77,btn78,btn79,btn80,btn81,btn82,btn83,btn84,btn85,btn86,btn87,btn88,btn89,btn90,btn91,btn92,btn93,btn94,btn95,btn96,btn97,btn98,btn99;
   @FXML
   Button shutDown;
   @FXML
  TextField attempts,status;
   static int noOfAttempts=3;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing");
        
        Object o[]=RetrieveData.retrieveData();
		String password=(String) o[0];
		String imei=(String) o[1];
		int period=(int) o[2];

		btn1.setOnAction(e->match(password,imei,period,Integer.parseInt(btn1.getText()),attempts,status));
		btn2.setOnAction(e->match(password,imei,period,Integer.parseInt(btn2.getText()),attempts,status));
		btn3.setOnAction(e->match(password,imei,period,Integer.parseInt(btn3.getText()),attempts,status));
		btn4.setOnAction(e->match(password,imei,period,Integer.parseInt(btn4.getText()),attempts,status));
		btn5.setOnAction(e->match(password,imei,period,Integer.parseInt(btn5.getText()),attempts,status));
		btn6.setOnAction(e->match(password,imei,period,Integer.parseInt(btn6.getText()),attempts,status));
		btn7.setOnAction(e->match(password,imei,period,Integer.parseInt(btn7.getText()),attempts,status));
		btn8.setOnAction(e->match(password,imei,period,Integer.parseInt(btn8.getText()),attempts,status));
		btn9.setOnAction(e->match(password,imei,period,Integer.parseInt(btn9.getText()),attempts,status));
		btn10.setOnAction(e->match(password,imei,period,Integer.parseInt(btn10.getText()),attempts,status));
		btn11.setOnAction(e->match(password,imei,period,Integer.parseInt(btn11.getText()),attempts,status));
		btn12.setOnAction(e->match(password,imei,period,Integer.parseInt(btn12.getText()),attempts,status));
		btn13.setOnAction(e->match(password,imei,period,Integer.parseInt(btn13.getText()),attempts,status));
		btn14.setOnAction(e->match(password,imei,period,Integer.parseInt(btn14.getText()),attempts,status));
		btn15.setOnAction(e->match(password,imei,period,Integer.parseInt(btn15.getText()),attempts,status));
		btn16.setOnAction(e->match(password,imei,period,Integer.parseInt(btn16.getText()),attempts,status));
		btn17.setOnAction(e->match(password,imei,period,Integer.parseInt(btn17.getText()),attempts,status));
		btn18.setOnAction(e->match(password,imei,period,Integer.parseInt(btn18.getText()),attempts,status));
		btn19.setOnAction(e->match(password,imei,period,Integer.parseInt(btn19.getText()),attempts,status));
		btn20.setOnAction(e->match(password,imei,period,Integer.parseInt(btn20.getText()),attempts,status));
		btn21.setOnAction(e->match(password,imei,period,Integer.parseInt(btn21.getText()),attempts,status));
		btn22.setOnAction(e->match(password,imei,period,Integer.parseInt(btn22.getText()),attempts,status));
		btn23.setOnAction(e->match(password,imei,period,Integer.parseInt(btn23.getText()),attempts,status));
		btn24.setOnAction(e->match(password,imei,period,Integer.parseInt(btn24.getText()),attempts,status));
		btn25.setOnAction(e->match(password,imei,period,Integer.parseInt(btn25.getText()),attempts,status));
		btn26.setOnAction(e->match(password,imei,period,Integer.parseInt(btn26.getText()),attempts,status));
		btn27.setOnAction(e->match(password,imei,period,Integer.parseInt(btn27.getText()),attempts,status));
		btn28.setOnAction(e->match(password,imei,period,Integer.parseInt(btn28.getText()),attempts,status));
		btn29.setOnAction(e->match(password,imei,period,Integer.parseInt(btn29.getText()),attempts,status));
		btn30.setOnAction(e->match(password,imei,period,Integer.parseInt(btn30.getText()),attempts,status));
		btn31.setOnAction(e->match(password,imei,period,Integer.parseInt(btn31.getText()),attempts,status));
		btn32.setOnAction(e->match(password,imei,period,Integer.parseInt(btn32.getText()),attempts,status));
		btn33.setOnAction(e->match(password,imei,period,Integer.parseInt(btn33.getText()),attempts,status));
		btn34.setOnAction(e->match(password,imei,period,Integer.parseInt(btn34.getText()),attempts,status));
		btn35.setOnAction(e->match(password,imei,period,Integer.parseInt(btn35.getText()),attempts,status));
		btn36.setOnAction(e->match(password,imei,period,Integer.parseInt(btn36.getText()),attempts,status));
		btn37.setOnAction(e->match(password,imei,period,Integer.parseInt(btn37.getText()),attempts,status));
		btn38.setOnAction(e->match(password,imei,period,Integer.parseInt(btn38.getText()),attempts,status));
		btn39.setOnAction(e->match(password,imei,period,Integer.parseInt(btn39.getText()),attempts,status));
		btn40.setOnAction(e->match(password,imei,period,Integer.parseInt(btn40.getText()),attempts,status));
		btn41.setOnAction(e->match(password,imei,period,Integer.parseInt(btn41.getText()),attempts,status));
		btn42.setOnAction(e->match(password,imei,period,Integer.parseInt(btn42.getText()),attempts,status));
		btn43.setOnAction(e->match(password,imei,period,Integer.parseInt(btn43.getText()),attempts,status));
		btn44.setOnAction(e->match(password,imei,period,Integer.parseInt(btn44.getText()),attempts,status));
		btn45.setOnAction(e->match(password,imei,period,Integer.parseInt(btn45.getText()),attempts,status));
		btn46.setOnAction(e->match(password,imei,period,Integer.parseInt(btn46.getText()),attempts,status));
		btn47.setOnAction(e->match(password,imei,period,Integer.parseInt(btn47.getText()),attempts,status));
		btn48.setOnAction(e->match(password,imei,period,Integer.parseInt(btn48.getText()),attempts,status));
		btn49.setOnAction(e->match(password,imei,period,Integer.parseInt(btn49.getText()),attempts,status));
		btn50.setOnAction(e->match(password,imei,period,Integer.parseInt(btn50.getText()),attempts,status));
		btn51.setOnAction(e->match(password,imei,period,Integer.parseInt(btn51.getText()),attempts,status));
		btn52.setOnAction(e->match(password,imei,period,Integer.parseInt(btn52.getText()),attempts,status));
		btn53.setOnAction(e->match(password,imei,period,Integer.parseInt(btn53.getText()),attempts,status));
		btn54.setOnAction(e->match(password,imei,period,Integer.parseInt(btn54.getText()),attempts,status));
		btn55.setOnAction(e->match(password,imei,period,Integer.parseInt(btn55.getText()),attempts,status));
		btn56.setOnAction(e->match(password,imei,period,Integer.parseInt(btn56.getText()),attempts,status));
		btn57.setOnAction(e->match(password,imei,period,Integer.parseInt(btn57.getText()),attempts,status));
		btn58.setOnAction(e->match(password,imei,period,Integer.parseInt(btn58.getText()),attempts,status));
		btn59.setOnAction(e->match(password,imei,period,Integer.parseInt(btn59.getText()),attempts,status));
		btn60.setOnAction(e->match(password,imei,period,Integer.parseInt(btn60.getText()),attempts,status));
		btn61.setOnAction(e->match(password,imei,period,Integer.parseInt(btn61.getText()),attempts,status));
		btn62.setOnAction(e->match(password,imei,period,Integer.parseInt(btn62.getText()),attempts,status));
		btn63.setOnAction(e->match(password,imei,period,Integer.parseInt(btn63.getText()),attempts,status));
		btn64.setOnAction(e->match(password,imei,period,Integer.parseInt(btn64.getText()),attempts,status));
		btn65.setOnAction(e->match(password,imei,period,Integer.parseInt(btn65.getText()),attempts,status));
		btn66.setOnAction(e->match(password,imei,period,Integer.parseInt(btn66.getText()),attempts,status));
		btn67.setOnAction(e->match(password,imei,period,Integer.parseInt(btn67.getText()),attempts,status));
		btn68.setOnAction(e->match(password,imei,period,Integer.parseInt(btn68.getText()),attempts,status));
		btn69.setOnAction(e->match(password,imei,period,Integer.parseInt(btn69.getText()),attempts,status));
		btn70.setOnAction(e->match(password,imei,period,Integer.parseInt(btn70.getText()),attempts,status));
		btn71.setOnAction(e->match(password,imei,period,Integer.parseInt(btn71.getText()),attempts,status));
		btn72.setOnAction(e->match(password,imei,period,Integer.parseInt(btn72.getText()),attempts,status));
		btn73.setOnAction(e->match(password,imei,period,Integer.parseInt(btn73.getText()),attempts,status));
		btn74.setOnAction(e->match(password,imei,period,Integer.parseInt(btn74.getText()),attempts,status));
		btn75.setOnAction(e->match(password,imei,period,Integer.parseInt(btn75.getText()),attempts,status));
		btn76.setOnAction(e->match(password,imei,period,Integer.parseInt(btn76.getText()),attempts,status));
		btn77.setOnAction(e->match(password,imei,period,Integer.parseInt(btn77.getText()),attempts,status));
		btn78.setOnAction(e->match(password,imei,period,Integer.parseInt(btn78.getText()),attempts,status));
		btn79.setOnAction(e->match(password,imei,period,Integer.parseInt(btn79.getText()),attempts,status));
		btn80.setOnAction(e->match(password,imei,period,Integer.parseInt(btn80.getText()),attempts,status));
		btn81.setOnAction(e->match(password,imei,period,Integer.parseInt(btn81.getText()),attempts,status));
		btn82.setOnAction(e->match(password,imei,period,Integer.parseInt(btn82.getText()),attempts,status));
		btn83.setOnAction(e->match(password,imei,period,Integer.parseInt(btn83.getText()),attempts,status));
		btn84.setOnAction(e->match(password,imei,period,Integer.parseInt(btn84.getText()),attempts,status));
		btn85.setOnAction(e->match(password,imei,period,Integer.parseInt(btn85.getText()),attempts,status));
		btn86.setOnAction(e->match(password,imei,period,Integer.parseInt(btn86.getText()),attempts,status));
		btn87.setOnAction(e->match(password,imei,period,Integer.parseInt(btn87.getText()),attempts,status));
		btn88.setOnAction(e->match(password,imei,period,Integer.parseInt(btn88.getText()),attempts,status));
		btn89.setOnAction(e->match(password,imei,period,Integer.parseInt(btn89.getText()),attempts,status));
		btn90.setOnAction(e->match(password,imei,period,Integer.parseInt(btn90.getText()),attempts,status));
		btn91.setOnAction(e->match(password,imei,period,Integer.parseInt(btn91.getText()),attempts,status));
		btn92.setOnAction(e->match(password,imei,period,Integer.parseInt(btn92.getText()),attempts,status));
		btn93.setOnAction(e->match(password,imei,period,Integer.parseInt(btn93.getText()),attempts,status));
		btn94.setOnAction(e->match(password,imei,period,Integer.parseInt(btn94.getText()),attempts,status));
		btn95.setOnAction(e->match(password,imei,period,Integer.parseInt(btn95.getText()),attempts,status));
		btn96.setOnAction(e->match(password,imei,period,Integer.parseInt(btn96.getText()),attempts,status));
		btn97.setOnAction(e->match(password,imei,period,Integer.parseInt(btn97.getText()),attempts,status));
		btn98.setOnAction(e->match(password,imei,period,Integer.parseInt(btn98.getText()),attempts,status));
		btn99.setOnAction(e->match(password,imei,period,Integer.parseInt(btn99.getText()),attempts,status));
		shutDown.setOnMouseEntered(e->{
			shutDown.setStyle("-fx-background-color: darkred; -fx-text-fill: white; -fx-border-color: black; -fx-font-size: 18; -fx-border-insets: 0; -fx-border-width: 3");
		});
		shutDown.setOnMouseExited(e->{
			shutDown.setStyle("-fx-background-color: #e52424; -fx-text-fill: white; -fx-border-color: black; -fx-font-size: 18; -fx-border-insets: 0; -fx-border-width: 3");
		});
        shutDown.setOnAction(e->{
			shutDown.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-border-color: black; -fx-font-size: 18; -fx-border-insets: 0; -fx-border-width: 3");

        	Runtime run=Runtime.getRuntime();
        	try {
				run.exec("shutdown -s -t "+0);

			} catch (IOException e1) {
				System.out.println("Something went wrong!");
				System.exit(0);
			}

		});
    }
    private static void match(String password,String imei,int period,int incomingKey,TextField attempts,TextField status) {
    	int passInt=PasswordAscii.passwordToInt(password);
    	int imeiInt=ImeiRot13.imeiToInt(imei);
    	int dateTimeInt=DateTime.DateTimeToInt(period);
    	int generatedKey=Math.abs(passInt+imeiInt+dateTimeInt)%100;
    	noOfAttempts--;
    	if(generatedKey==incomingKey) {
			ProcessBuilder pb=new ProcessBuilder("C:\\Windows\\system32\\userinit.exe");
			try {
				pb.start();
			} catch (IOException ioException) {
				try {
					pb.start();
				} catch (IOException e) {
					System.exit(0);
				}
			}
    		System.exit(0);
		}
    	else
    	{
    		attempts.clear();
    		attempts.appendText(noOfAttempts+" Attempts Left");
    		if(noOfAttempts<=0) {
    			Alert alert=new Alert(Alert.AlertType.ERROR);
        		alert.initModality(Modality.APPLICATION_MODAL);
                alert.setHeaderText("Unauthorised User");
                alert.setContentText("Shutting Down PC");
		        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));

                alert.setOnShowing(e->{
                	Thread myThred=new Thread() {
                		public void run() {
                			try {
                				Runtime run=Runtime.getRuntime();
								Thread.sleep(1200);
								System.out.println("shutting down");
								run.exec("shutdown -s -t "+0);
                			}
                			catch (Exception e) {
								System.out.println("Something went wrong");
								ProcessBuilder pb=new ProcessBuilder("C:\\Windows\\system32\\userinit.exe");
								try {
									pb.start();
								} catch (IOException ioException) {
									try {
										pb.start();
									} catch (IOException et) {
										System.exit(0);
									}
								}
					    		System.exit(0);
							} 
                		}
                		};
                		myThred.start();
                	});
                alert.show();	
    		}
    	else {
    			status.setStyle("-fx-background-color: black; -fx-text-fill:white;-fx-border-color:red; -fx-border-radius: 300; -fx-border-width: 3;");
    			status.clear();
    			status.appendText("Wrong Answer");
    			TranslateTransition tn=new TranslateTransition();
    	        tn.setDuration(Duration.seconds(0.35));
    	        tn.setNode(attempts);
    	        tn.setToX(+35);
    	        tn.setAutoReverse(true);
    	        tn.setCycleCount(2);
    	        tn.setOnFinished(e->{
        	        status.setStyle("-fx-background-color: black; -fx-text-fill:white;-fx-border-color: #1bff1b; -fx-border-radius: 300; -fx-border-width: 3;");
        	        status.clear();
        			status.appendText("Try Again");
    	        });
    	        tn.play();
    	        
    	        
    		System.out.println("Wrong");
    
    		
    		}
    	}
    		
    }
}
