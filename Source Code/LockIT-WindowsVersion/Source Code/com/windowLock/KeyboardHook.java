package com.windowLock;
//For exception
import java.io.IOException;

//For keyboard Hooking
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;

import com.sun.jna.platform.win32.WinUser;

public class KeyboardHook implements Runnable {
	private WinUser.HHOOK hhk;
	// hook callback function
	private WinUser.LowLevelKeyboardProc keyboardProc = new WinUser.LowLevelKeyboardProc() {
		Runtime run = Runtime.getRuntime();
		@Override
		public LRESULT callback(int nCode, WPARAM wParam, WinUser.KBDLLHOOKSTRUCT event) {
			if (nCode >= 0) {
				System.out.println("nCode:" + wParam + ", KEY: " + event.vkCode);
				 // Screen windows, alt, tab, del key
				switch (event.vkCode) {
				case 27:// esc
					if (wParam.intValue() == 256) {
					}
				case 91: // windows
				case 162:// ctrl
				case 164:// alt
				case 9:// tab
				case 115:// f4
				case 116:// f5
				case 123:// f12
				case 46:// del
									 try {
											run.exec("shutdown -s -t "+0);
										} catch (IOException e) {
											try {
												run.exec("shutdown -s -t "+0);
											} catch (IOException e1) {
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

								

					return new LRESULT(1);
				}
			}
			return User32.INSTANCE.CallNextHookEx(hhk, nCode, wParam, null);
		}
 
	};
 
	public void run() {
		System.out.println("Hook On!");
		HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
		hhk = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, keyboardProc, hMod, 0);
		int result;
		WinUser.MSG msg = new WinUser.MSG();
		while ((result = User32.INSTANCE.GetMessage(msg, null, 0, 0)) != 0) {
			System.out.println(System.currentTimeMillis() + "!");
			if (result == -1) {
			} else {
				User32.INSTANCE.TranslateMessage(msg);
				User32.INSTANCE.DispatchMessage(msg);
			}
		}
	}
}