package com.encrypting;

public class ImeiRot13 {
public static int imeiToInt(String in) {
	int imei[] = new int[in.length()];
	for(int i=0;i<in.length();i++)
	{
		int temp=Integer.parseInt(in.substring(i,i+1));
		imei[i]=temp+13;
	}
	int rot13Int=0;
	for(int i=0;i<imei.length;i++)
	{
		int temp=imei[i];
		rot13Int+=temp;
	}
	return rot13Int;
	
}

}
