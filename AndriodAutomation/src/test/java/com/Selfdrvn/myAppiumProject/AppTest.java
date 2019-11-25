package com.Selfdrvn.myAppiumProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
public class AppTest {
	
	
  String hostName = "smtp.gmail.com";
  String username = "lakshmi.chaithanya019@gmail.com";
  String password = "thejdeep1991";
  int messageCount;
  int unreadMsgCount;
  String emailSubject;
 
	
  public static URL url;
  public static DesiredCapabilities capabilities;
  public static AndroidDriver<MobileElement> driver;
  
  
  
  @BeforeSuite
  public void setupAppium() throws MalformedURLException {
    
    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
    url = new URL(URL_STRING);

    capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
    capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\puttaparthi\\Desktop\\com.mobi.wallet_2019-10-17.apk");
    capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, "com.mobi.wallet.*");
    capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

 
    driver = new AndroidDriver<MobileElement>(url, capabilities);
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    
    
 
  
  }
 
  
  @Test
  public void myFirstTest() throws InterruptedException {
	  
	  
      Thread.sleep(10000);
          
 /*   WebElement signIn= driver.findElement(By.xpath("//android.widget.Button[@text=\"SIGN IN\"]"));
      
      signIn.click();
      
      Thread.sleep(5000); */
      
      
      WebElement SignUpLink= driver.findElement(By.id("com.mobi.wallet:id/tvSignUp"));
      
      SignUpLink.click();
      
      WebElement FullNameTextbox= driver.findElement(By.id("com.mobi.wallet:id/edtFullName"));
      
      FullNameTextbox.sendKeys("VarshaReddy");
          
      WebElement EmailTextbox= driver.findElement(By.id("com.mobi.wallet:id/edtEmail"));
      
      EmailTextbox.sendKeys("vangalanihanthreddy@gmail.com");
           
      WebElement PasswordTextbox= driver.findElement(By.id("com.mobi.wallet:id/edtPassword"));
      
      PasswordTextbox.sendKeys("12345@Test");
          
      WebElement ConfirmPasswordTextbox= driver.findElement(By.id("com.mobi.wallet:id/edtConfirmPassword"));
      
      ConfirmPasswordTextbox.sendKeys("12345@Test");
      		
      WebElement Submitbutton= driver.findElement(By.id("com.mobi.wallet:id/btnSubmit"));
      
      Submitbutton.click();
      
      Thread.sleep(40000);
      
      driver.openNotifications();
            
      Thread.sleep(5000);
      
      WebElement MailNotification= driver.findElement(By.id("android:id/big_text"));
      
      String Mail =MailNotification.getText();
      
      System.out.println(Mail);

      Thread.sleep(2000);
      
      String OTP = Mail.substring(404,410); 
      
      System.out.println(OTP);
          
      WebElement CLEARNotification= driver.findElement(By.id("com.android.systemui:id/dismiss_text"));
      
      CLEARNotification.click();
      
      Thread.sleep(3000);
      
      WebElement EnterOTPText= driver.findElement(By.id("com.mobi.wallet:id/edtVerifyCode"));
      
      EnterOTPText.sendKeys(OTP);    
      
      WebElement noReferrallCheckBox= driver.findElement(By.id("com.mobi.wallet:id/rbHavent"));
      
      noReferrallCheckBox.click();
      
      WebElement SubmitButton= driver.findElement(By.id("com.mobi.wallet:id/btnSubmitReferral"));
      
      SubmitButton.click();
     
      WebElement YesButton= driver.findElement(By.id("android:id/button1"));
      
      YesButton.click();
      
      System.out.println("Sign UP Successful");
      
     	  
  }
  
  
 
  
  /*
  public String MailReader() throws InterruptedException
  {
	    Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");
	    String otp = null;
	    Thread.sleep(6000);
	    try {
	        Session session = Session.getInstance(sysProps, null);
	        Store store = session.getStore();
	        store.connect(hostName, username, password);
	        Folder emailInbox = store.getFolder("INBOX");
	        emailInbox.open(Folder.READ_WRITE);
	        messageCount = emailInbox.getMessageCount();
	        System.out.println("Total Message Count: " + messageCount);
	        unreadMsgCount = emailInbox.getNewMessageCount();
	        System.out.println("Unread Emails count:" + unreadMsgCount);
	        emailMessage = emailInbox.getMessage(messageCount);
	        emailSubject = emailMessage.getSubject();
	        
	      
            Pattern linkPattern = Pattern.compile("(.*)Expire"); 
	        Matcher pageMatcher =
	                linkPattern.matcher(emailMessage.getContent().toString());
            String value = pageMatcher.group(1);
	        while (pageMatcher.find()) {
	            System.out.println("Found OTP " + pageMatcher.group(1));   
            }
	        
   
	        emailMessage.setFlag(Flags.Flag.SEEN, true);
	        emailInbox.close(true);
	        store.close();

	    } catch (Exception mex) {
	        mex.printStackTrace();
	    }

		return otp;
	    
	} */


  
}