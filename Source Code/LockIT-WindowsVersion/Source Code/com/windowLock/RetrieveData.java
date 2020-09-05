package com.windowLock;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.admin.AdminGUI;
import com.main.ObjectForSave;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RetrieveData {
	private static ObjectInputStream ois;
	public static Object[] retrieveData() {
		
		Object[] data=new Object[3];
		
		ObjectForSave userObj=new ObjectForSave();
		try {
			FileInputStream fis = new FileInputStream("C:\\users\\"+System.getProperty("user.name")+"\\AppData\\Local\\LockIT\\"+ System.getProperty("user.name")+".lockIt");
			ois = new ObjectInputStream(fis);
			userObj=(ObjectForSave) ois.readObject();
			//Decryption
			String password=userObj.getPassword();
			String imei=userObj.getImei();
			int period=userObj.getPeriod();
			
					StringBuffer imeiTemp=new StringBuffer("");
					for(int i=0;i<imei.length();i++)
					{
						char c=imei.charAt(i);	
						int e=(c-96);
						imeiTemp.append(Integer.toString(e));
					}
					imei=new String(imeiTemp);

					StringBuffer passTemp=new StringBuffer("");
					for(int i=0;i<password.length();i++)
					{

						char e=(char) (password.charAt(i)-13);
						passTemp.append(Character.toString(e));
					}
					password=new String(passTemp);
					
			//Saving
			data[0]=password;
			data[1]=imei;
			data[2]=period;
			return data;
		} 
		catch(Exception ex) {

			Alert alert=new Alert(Alert.AlertType.ERROR);
    		alert.initModality(Modality.APPLICATION_MODAL);
    		alert.setHeaderText("Lock not set");
			alert.setContentText("First set the lock using LockIT Admin Panel");
	          ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(AdminGUI.class.getResourceAsStream("icon.png")));

            alert.setOnShowing(e->{
            Thread myThred=new Thread() {
        		public void run() {
        			try {
						Thread.sleep(1500);
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
        			catch (Exception e) {
						System.out.println("Something went wrong");
            			System.exit(0);
					} 
        		}
        		};
        		myThred.start();
            });
            alert.showAndWait();
            data[0]="";
       		data[1]="";
       		data[2]=0;
       		return data; 

		}
		
		
		
	}

}
