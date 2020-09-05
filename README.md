<h2>LockIT-Window Lock<h2>
<h6>Creater : Hritik Handa - hritikhanda4@gmail.com</h6>
<h6>Co-Creator : Abhinandan Kumar– abhinandankumar381@gmail.com</h6>
<p>LockIT is a window lock made to protect all your confidential data from unauthorized accesses. LockIT replaces the original window login lock and it is a simple paradigm based on the generation of a unique OTP key every time based on four factors:</p>
<ol>     
<li>	<b>Password: </b>This acts as a backup password, Also internally the unique key is dependent on this, can be of your choice, must be at least 6 characters long.
</li>
<li>
<b>IMEI Number:</b> For every device, there is a unique IMEI, LockIT uses this IMEI number and make the generation of unique OTP key unique for every device i.e. The same details if filled in another device will not generate the same OTP key, can be found by dialing *#06# in your keypad.
</li>
<li>
<b>Period or Validity period: </b>The time for which a particular OTP key will be valid is determined by the Validity Period.  
Example: if you set Period=10 min, then for 5:00 to 5:10, a unique key will be generated, for 5:11 to 5:20 unique key will be generated.
</li>
<li>
<b>DateAndTime: </b>LockIT generates unique OTP key dependent on date and time, So every time a unique OTP key will be generated from LockIT APK.     
</li>
</ol>
<h3>Requirements:</h3>
<p>Java 8 or higher: You must have java 1.8 or higher version installed in your PC otherwise your PC will not start once you setup the lock</p>
<h3>Screenshots</h3>
  <img src="images/WindowsLock.jpg"></img>
  <img width=50% height=50% src="images/AdminPanel.JPG"></img>
  <img width=25% height=25% src="images/hello.jpg"></img><img width=25% height=25% src="images/2.jpg"></img><img  width=25% height=25%  src="images/3.jpg"></img>
  
<h3>Process for setting up LockIT:</h3>
<p>LockIT includes 2 phases, One to set up the windows version (Main Lock) and another to set up the Android version (OTP key generator).</p>
<h4>1. Windows Lock Setup (Windows):</h4>
<h6>*****You can watch setupWindowsLock video for proper installation *****</h6>
<p>
Step 1: Download the LockIT-WindowsVersion folder <br>
Step 2: Place the LockIT-WindowsVersion Folder in C:// drive <br>
  <img width=50% height=50% src="images/image001.png"></img><br>
Step 3: Open the LockIT-WindowsVersion Folder  and run AdminPanel.bat file <br> 
<img width=50% height=50% src="images/image003.png"></img><br>
Step 4: Click on the Set New Settings tab and fill the required details and click on LockIt <br>
 <img width=50% height=50% src="images/image005.png"></img><br>
Step 5: All data will be saved successfully and you can change the details from the same AdminPanel.bat as well <br>
Step 6: Open run using Windows+R and type “regedit” in it and press enter. <br>
 <img width=50% height=50% src="images/image007.png"></img><br>
Step 7: Now Copy “Computer\HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Winlogon” and paste it on the URL bar of Registry Editor <br>
Step 8: Now copy “C:\LockIT-WindowsVersion\WindowsLock.bat” <br>
 <img width=50% height=50% src="images/image009.png"></img><br>
Step 9: Find a file named Userinit in the registry editor and right-click on it and click on modify <br>
Step 10: Paste the copied “C:\LockIT-WindowsVersion\WindowsLock.bat” in the Value data field. <br>
 <img width=50% height=50% src="images/image011.png"></img><br>
Step 11: Click ok and You are all set. <br>
</p>

<h4>2. Generator Setup (Android): </h4>
<h6>*****You can watch setupLockItGenerator video for proper installation *****</h6>
<p>
Step 1: Install the apk of LockIT in your android phone <br>
Step 2: Run the app and fill all the required details <br>
NOTE: The details must be the same as added in window version of LockIT <br> 
   <img width=25% height=25% src="images/image013.jpg"></img><br>
Step 3: Click on generate to generate the OTP key for your window lock at that particular time. <br>
 <img width=25% height=25% src="images/image015.jpg"></img><br>
Step 4: You are all set, Also you can change and manipulate the saved data but you need your backup password for this process. <br>
</p>
