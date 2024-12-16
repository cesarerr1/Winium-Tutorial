package pages;

import org.openqa.selenium.By;

public class Venta {

    public By btnAceptarNotificacion = By.id("btnAceptar");
    public By btnCancelarNotificacion = By.id("btnCancelar");
    public By editTextEfectivo = By.id("amountTextBox");
    private By producto = By.id("");
    public By ventanaDonativo = By.name("Confirmación de donativo");
    public By motivoCancelacion = By.id("PART_EditableTextBox");

    public By producto(String name){
        return  this.producto = By.name(name);
    }
}
