package com.admin;

import java.io.File;


public class UserExist {
	public static boolean isExist() {
        	File f=new File("C:\\users\\"+System.getProperty("user.name")+"\\AppData\\Local\\LockIT");
        	File f2=new File("C:\\users\\"+System.getProperty("user.name")+"\\AppData\\Local\\LockIT\\"+ System.getProperty("user.name")+".lockIt");
			if(f.exists()&&f2.exists())
				return true;
			return false;
	}
}
