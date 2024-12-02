package steps;

import io.cucumber.java.es.Y;
import org.openqa.selenium.winium.WiniumDriver;
import pages.Donativo;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;

public class DonativoSteps {

    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private ReporteAllure allure = new ReporteAllure();
    private Donativo donativo = new Donativo();

    @Y("digito el monto a donar {string}")
    public void digitoElMontoADonar(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,donativo.montoDonar,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,donativo.montoDonar,arg0,15);
        allure.capturaAllure(winiumDriver);
    }

    @Y("digito {string} en pago en efectivo")
    public void digitoEnPagoEnEfectivo(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,donativo.efectivo,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,donativo.efectivo,arg0,15);
        allure.capturaAllure(winiumDriver);
    }

    @Y("doy click en procesar pago")
    public void doyClickEnProcesarPago() throws InterruptedException {
        funcionesAuxiliares.atajoTeclas("F11");
        Thread.sleep(4);
        allure.capturaAllure(winiumDriver);
    }
}
