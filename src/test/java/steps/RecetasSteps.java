package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.openqa.selenium.winium.WiniumDriver;
import pages.Login;
import pages.PaginaPrincipal;
import pages.Recetas;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;

public class RecetasSteps {

    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private Login login = new Login();
    private PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private ReporteAllure allure = new ReporteAllure();
    private Recetas recetas = new Recetas();

    @Dado("que doy click en recetas")
    public void queDoyClickEnRecetas() {
        funcionesAuxiliares.esperarElemento(winiumDriver,paginaPrincipal.btnF7Recetas,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,paginaPrincipal.btnF7Recetas,15);
    }

    @Y("doy click en agregar o editar doctor")
    public void doyClickEnAgregarOEditarDoctor() {
        funcionesAuxiliares.esperarElemento(winiumDriver,recetas.btnAgregarEditarDoctor,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,recetas.btnAgregarEditarDoctor,15);
    }

    @Y("escribo la cedula {string}")
    public void escriboLaCedula(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,recetas.editTextCedula,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,recetas.editTextCedula,arg0,15);
        allure.capturaAllure(winiumDriver);
    }

    @Y("elijo {string}")
    public void elijo(String arg0) {
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg0);
        allure.capturaAllure(winiumDriver);
    }

    @Y("escribo {string} {string} {string}")
    public void escribo(String arg0, String arg1, String arg2) {
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg0);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg1);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg2);
        allure.capturaAllure(winiumDriver);
    }


    @Y("escribo los moviles {string} {string}")
    public void escriboLosMoviles(String arg0, String arg1) {
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg0);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg1);
        allure.capturaAllure(winiumDriver);
    }

    @Y("escribo el correo {string}")
    public void escriboElCorreo(String arg0) {
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg0);
        allure.capturaAllure(winiumDriver);
    }

    @Y("registro {string}")
    public void registro(String arg0) {
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg0);
        allure.capturaAllure(winiumDriver);
    }

    @Y("sin comentarios")
    public void sinComentarios() {
        funcionesAuxiliares.atajoTeclas("TAB");
        allure.capturaAllure(winiumDriver);
    }

    @Y("escribo la {string} {string} {string} {string} {string} {string}")
    public void escriboLa(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg0);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg1);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg2);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg3);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg4);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg5);
        allure.capturaAllure(winiumDriver);

    }

    @Y("doy click en aceptar en la ventana de doctores")
    public void doyClickEnAceptarEnLaVentanaDeDoctores() {
        funcionesAuxiliares.esperarElemento(winiumDriver,recetas.btnAceptar,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,recetas.btnAceptar,15);
        funcionesAuxiliares.click(winiumDriver,recetas.btnABCDoctores,15);
        funcionesAuxiliares.click(winiumDriver,recetas.btnABCDoctores,15);
        funcionesAuxiliares.esperarElemento(winiumDriver,recetas.btnAceptarAsignarDoctor,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,recetas.btnCerrarRecetaMedica,15);
        funcionesAuxiliares.click(winiumDriver,recetas.btnABCDoctores,15);
        funcionesAuxiliares.click(winiumDriver,recetas.btnABCDoctores,15);
    }

    @Y("cierro la ventana de Captura de Receta Médica")
    public void cierroLaVentanaDeCapturaDeRecetaMédica() throws InterruptedException {
        Thread.sleep(2000);
        funcionesAuxiliares.esperarElemento(winiumDriver,recetas.btnCerrarRecetaMedica,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,recetas.btnCerrarRecetaMedica,15);
    }
}
