package steps;

import io.cucumber.java.es.Y;
import org.openqa.selenium.winium.WiniumDriver;
import pages.Botones;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;

public class BotonesSteps {

    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private ReporteAllure allure = new ReporteAllure();
    private Botones botones = new Botones();

    @Y("doy click en {string}")
    public void doyClickEn(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,botones.btnUniversal(arg0),15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,botones.btnUniversal(arg0),15);
    }
}
