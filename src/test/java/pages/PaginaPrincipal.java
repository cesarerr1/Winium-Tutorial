package pages;

import org.openqa.selenium.By;

public class PaginaPrincipal {

    public By btnContinuarCajaInicial = By.name("Continuar");
    public By textAtiende = By.name("Te Atiende MARIA MARTINA");
    private By teAtiende = By.name("");
    public By menuPrincipal = By.id("menuAccessToggleButton");
    public By SKU = By.id("skuTxt");
    public By btnF7Recetas = By.name("Recetas");


    public By teAtiende(String name){
        return this.teAtiende = By.name("Te Atiende "+name);
    }

}
