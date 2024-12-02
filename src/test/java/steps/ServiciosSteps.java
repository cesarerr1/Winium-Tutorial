package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.openqa.selenium.winium.WiniumDriver;
import pages.Login;
import pages.PaginaPrincipal;
import pages.Servicios;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;

public class ServiciosSteps {

    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private ReporteAllure allure = new ReporteAllure();
    private Servicios servicios = new Servicios();


    @Dado("que uso el atajo de teclas {string}")
    public void queUsoElAtajoDeTeclas(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,paginaPrincipal.textAtiende,15);
        funcionesAuxiliares.atajoTeclas(arg0);
        allure.capturaAllure(winiumDriver);
    }

    @Y("doy click en entretenimiento")
    public void doyClickEnEntretenimiento() {
        funcionesAuxiliares.esperarElemento(winiumDriver,servicios.btnEntretenimiento,15);
        funcionesAuxiliares.click(winiumDriver,servicios.btnEntretenimiento,15);
        allure.capturaAllure(winiumDriver);
    }

    @Y("doy click en sorteos")
    public void doyClickEnSorteos() {
        funcionesAuxiliares.esperarElemento(winiumDriver,servicios.btnSorteos,15);
        funcionesAuxiliares.click(winiumDriver,servicios.btnSorteos,15);
        allure.capturaAllure(winiumDriver);
    }

    @Y("selecciono {string}")
    public void selecciono(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,servicios.cbServicios,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,servicios.cbServicios,arg0,15);
        funcionesAuxiliares.atajoTeclas("ENTER");
        allure.capturaAllure(winiumDriver);
    }

    @Y("digito {string}")
    public void digito(String arg0) throws InterruptedException {
        Thread.sleep(4000);
        funcionesAuxiliares.escribirTexto(arg0);
        allure.capturaAllure(winiumDriver);
    }

    @Y("tecleo {string}")
    public void tecleo(String arg0) {
        funcionesAuxiliares.atajoTeclas(arg0);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.esperarElemento(winiumDriver,servicios.btnAceptar,15);
        funcionesAuxiliares.click(winiumDriver,servicios.btnAceptar,15);
        funcionesAuxiliares.atajoTeclas("ESC");
        funcionesAuxiliares.esperarElemento(winiumDriver,servicios.btnAceptar,15);
        funcionesAuxiliares.click(winiumDriver,servicios.btnAceptar,15);
    }

    @Y("escribo la referencia {string}")
    public void escriboLaReferencia(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,servicios.tbReferencia,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,servicios.tbReferencia,arg0,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.atajoTeclas("F10");
    }
}
