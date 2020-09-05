package com.main;
import java.io.Serializable;

public class ObjectForSave implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6611028409345770622L;
	private String imei;
	private String password;
	private int period;

	//setter functions
	public void setImei(String imei) {
		this.imei=imei;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setPeriod(int period) {
		this.period=period;
	}
	
	//getter functions
		public String getImei() {
			return this.imei;
		}
		public String getPassword() {
			return this.password;
		}
		public int getPeriod() {
			return this.period;
		}

	
}