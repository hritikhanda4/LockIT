package com.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import com.main.ObjectForSave;
public class WriteData {

	public static void writeData(String imei,String password,int period)
	{
		//Encryption
		StringBuffer imeiTemp=new StringBuffer("");
		for(int i=0;i<imei.length();i++)
		{
			String c=imei.substring(i,i+1);	
			int d=Integer.parseInt(c);
			char e=(char) (96+d);
			imeiTemp.append(Character.toString(e));
		}
		imei=new String(imeiTemp);

		StringBuffer passTemp=new StringBuffer("");
		for(int i=0;i<password.length();i++)
		{

			char e=(char) (13+password.charAt(i));
			passTemp.append(Character.toString(e));
		}
		password=new String(passTemp);
		
		
		//Creating object for serialization
		
		ObjectForSave userObject=new ObjectForSave();
			userObject.setImei(imei);
			userObject.setPassword(password);
			userObject.setPeriod(period);
			File f=new File("C:\\users\\"+System.getProperty("user.name")+"\\AppData\\Local\\LockIT");
			if(!f.exists())
			{
			f.mkdir();
			
			}
			f=new File("C:\\users\\"+System.getProperty("user.name")+"\\AppData\\Local\\LockIT\\"+ System.getProperty("user.name")+".lockIt");
			if(!f.exists())
			{
				try {
					f.createNewFile();
				} catch (IOException e) {
					System.out.println("Something went Wrong");
				}
			}else
			{
				f.delete();
				try {
					f.createNewFile();
				} catch (IOException e) {
					System.out.println("Something went wrong");
				}
			}

				try {
					
					FileOutputStream fos=new FileOutputStream("C:\\users\\"+System.getProperty("user.name")+"\\AppData\\Local\\LockIT\\"+ System.getProperty("user.name")+".lockIt");
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					oos.writeObject(userObject);
					System.out.println("User saved");
					oos.close();
					fos.close();
					
				} catch (IOException e) {
					System.out.println("Something went Wrong");
				}
	}
			

}
