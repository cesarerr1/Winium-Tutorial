package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ReporteAllure {
    public void capturaAllure(WiniumDriver driver){
        if(driver != null){
            byte[] screenshotBytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(screenshotBytes)){
                Allure.attachment("Captura de allure",inputStream);
            } catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Driver no iniciado");
        }
    }
}
