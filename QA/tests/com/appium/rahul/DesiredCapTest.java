package com.appium.rahul;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DesiredCapTest {

    @Test
    public void setup() throws Exception {
        System.out.println("Program starts...");

        File appDir = new File("aut/android");
        File aut = new File(appDir, "bookMyShow-ucb.apk");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Ändroid Emulator");

        /*cap.setCapability(MobileCapabilityType.DEVICE_NAME, "YUREKA");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");*/

        /*cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 3");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");*/

        //How long (in seconds) Appium will wait for a new command from the client before assuming the client quit and ending the session.
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        cap.setCapability(MobileCapabilityType.APP, aut.getAbsolutePath());
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElementById("com.bt.bms:id/btnLogin").click();

        driver.findElementById("com.bt.bms:id/btnSignUp").click();
        int size = driver.findElementsByClassName("android.widget.EditText").size();

        List<WebElement> elements = driver.findElementsByClassName("android.widget.EditText");
        System.out.println("Size: " + elements.size());

        elements.get(0).sendKeys("Appium");
        elements.get(1).sendKeys("Mobile");
        elements.get(2).sendKeys("appium@gmail.com");
        elements.get(3).sendKeys("password");

        driver.findElementById("com.bt.bms:id/action_icon").click();
        Thread.sleep(2000);
        driver.findElementById("com.bt.bms:id/dismiss").click();

        Thread.sleep(10000);
        driver.closeApp();
        driver.quit();

    }



}