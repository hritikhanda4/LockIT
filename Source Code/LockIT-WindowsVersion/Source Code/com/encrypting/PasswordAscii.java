package com.encrypting;

public class PasswordAscii {
	public static int passwordToInt(String in) {
		int ascii[] = new int[in.length()];
		int passwordInt=0;
		for(int i=0;i<in.length();i++)
		{
			ascii[i]=(in.charAt(i));
		}
		for(int i=0;i<ascii.length;i++)
		{
			passwordInt+=ascii[i];
		}
		
		return passwordInt;
	}
}
