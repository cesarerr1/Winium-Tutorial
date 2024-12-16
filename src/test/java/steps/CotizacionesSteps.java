package steps;

import io.cucumber.java.es.Y;
import org.openqa.selenium.winium.WiniumDriver;
import pages.*;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;

public class CotizacionesSteps {

    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private ReporteAllure allure = new ReporteAllure();
    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private Cotizaciones cotizaciones = new Cotizaciones();

    @Y("doy click en aceptar autorización")
    public void doyClickEnAceptarAutorización() {
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,cotizaciones.btnLoginRF,15);
    }

    @Y("escribo el SKU {string} del producto")
    public void escriboElSKUDelProducto(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,cotizaciones.tbSKU,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,cotizaciones.tbSKU,arg0,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.atajoTeclas("ENTER");
    }

    @Y("escribo el cliente prospecto {string}")
    public void escriboElClienteProspecto(String arg0) {
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg0);
        allure.capturaAllure(winiumDriver);
    }

    @Y("presiono la tecla {string}")
    public void presionoLaTecla(String arg0) {
        funcionesAuxiliares.atajoTeclas("F10");
    }

    @Y("doy click en aceptar confirmación")
    public void doyClickEnAceptarConfirmación() {
        funcionesAuxiliares.esperarElemento(winiumDriver,cotizaciones.btnAceptarConfirmacion,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,cotizaciones.btnAceptarConfirmacion,15);
        funcionesAuxiliares.click(winiumDriver,cotizaciones.btnAceptarConfirmacion,15);
    }

    @Y("doy click en cancelar impresión")
    public void doyClickEnCancelarImpresión() {
        funcionesAuxiliares.esperarElemento(winiumDriver,cotizaciones.btnCancelar,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,cotizaciones.btnCancelar,15);
    }

}
