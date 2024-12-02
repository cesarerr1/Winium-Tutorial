package utils;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WiniumDriverManager {

    private static WiniumDriver driver;

    public static  WiniumDriver runDriver(){
        if(driver == null){
            DesktopOptions options = new DesktopOptions();
            options.setApplicationPath(ConfigManager.getApplicationPath());
            try{
                driver = new WiniumDriver(new URL(ConfigManager.getWiniumDriverUrl()),options);
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static WiniumDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        if(driver !=null){
            driver.quit();
            driver=null;
        }
    }
}
