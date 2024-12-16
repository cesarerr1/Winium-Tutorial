package pages;

import org.openqa.selenium.By;

public class Botones {
    private By btn = By.name("");


    public By btnUniversal(String nombreBTN){
        return this.btn = By.name(nombreBTN);
    }
}
