package com.main;

import com.encrypting.DateTime;
import com.encrypting.ImeiRot13;
import com.encrypting.PasswordAscii;
import com.windowLock.RetrieveData;

public class Generator {
	public static void main(String args[])
	{
		//Retrieving the saved parameters
		Object o[]=RetrieveData.retrieveData();
		String password=(String) o[0];
		String imei=(String) o[1];
		int period=(int) o[2];
		
		//Generating mainKey
		int passInt=PasswordAscii.passwordToInt(password);
    	int imeiInt=ImeiRot13.imeiToInt(imei);
    	int dateTimeInt=DateTime.DateTimeToInt(period);
    	int generatedKey=Math.abs(passInt+imeiInt+dateTimeInt)%100;
    	System.out.println(generatedKey);
    	try {
			Thread.sleep(5000);
		}
    	catch(InterruptedException e){

		}

	}
}
