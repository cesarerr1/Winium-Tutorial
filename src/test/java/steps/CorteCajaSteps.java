package steps;

import io.cucumber.java.es.Dado;
import org.openqa.selenium.winium.WiniumDriver;
import pages.CorteCaja;
import pages.PaginaPrincipal;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;


public class CorteCajaSteps {

    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private CorteCaja corteCaja = new CorteCaja();
    private ReporteAllure allure = new ReporteAllure();
    private PaginaPrincipal paginaPrincipal = new PaginaPrincipal();

    @Dado("que uso el atajo de teclas {string} + {string}")
    public void queUsoElAtajoDeTeclas(String Key1, String Key2) {
        try {
            Thread.sleep(10000);
            funcionesAuxiliares.esperarElemento(winiumDriver,paginaPrincipal.textAtiende,15);
            funcionesAuxiliares.atajoTeclas(Key1,Key2);
            allure.capturaAllure(winiumDriver);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Dado("escribo las credenciales de MF {string} {string}")
    public void escribo_las_credenciales_de_mf(String usuario, String password) {
        if(funcionesAuxiliares.esperarElemento(winiumDriver,corteCaja.autorizacionUsuario,15)){
            funcionesAuxiliares.enviarDatos(winiumDriver,corteCaja.autorizacionUsuario,usuario,15);
            funcionesAuxiliares.enviarDatos(winiumDriver,corteCaja.autorizacionPassword,password,15);
        }else{
            funcionesAuxiliares.escribirTexto(usuario);
            funcionesAuxiliares.atajoTeclas("TAB");
            funcionesAuxiliares.escribirTexto(password);
            funcionesAuxiliares.atajoTeclas("TAB");
            funcionesAuxiliares.atajoTeclas("ENTER");
        }

        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,corteCaja.btnAutorizacionAceptar,15);
    }
    @Dado("doy click en aceptar en la ventana")
    public void doy_click_en_aceptar_en_la_ventana() {
        funcionesAuxiliares.esperarElemento(winiumDriver,corteCaja.btnAceptarConfirmacion,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,corteCaja.btnAceptarConfirmacion,15);
    }
    @Dado("doy click en procesar")
    public void doy_click_en_procesar() throws InterruptedException {
        funcionesAuxiliares.esperarElemento(winiumDriver,corteCaja.btnProcesar,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,corteCaja.btnProcesar,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,corteCaja.btnAceptarConfirmacion,15);
        if(funcionesAuxiliares.esperarElemento(winiumDriver,corteCaja.btnAceptarConfirmacion,15)){
            funcionesAuxiliares.click(winiumDriver,corteCaja.btnAceptarConfirmacion,15);
            //Thread.sleep(5000);
            //funcionesAuxiliares.click(winiumDriver,corteCaja.btnAceptarConfirmacion,15);
            funcionesAuxiliares.enviarDatos(winiumDriver,corteCaja.editTextDiferencia,"83",15);
            funcionesAuxiliares.click(winiumDriver,corteCaja.btnContinuar,15);
            funcionesAuxiliares.click(winiumDriver,corteCaja.btnAceptarConfirmacion,15);
        }
    }
    @Dado("escribo las credenciales de RF {string} {string}")
    public void escribo_las_credenciales_de_rf(String usuario, String password) {
        funcionesAuxiliares.enviarDatos(winiumDriver,corteCaja.Usuario,usuario,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,corteCaja.Password,password,15);
        allure.capturaAllure(winiumDriver);
    }
    @Dado("doy click en aceptar la autorizacion")
    public void doy_click_en_aceptar_la_autorizacion() {
        funcionesAuxiliares.esperarElemento(winiumDriver,corteCaja.btnAutorizacionAceptar,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,corteCaja.btnAutorizacionAceptar,15);
    }
    @Dado("doy click en aceptar en la notificacion")
    public void doy_click_en_aceptar_en_la_notificacion() {
        funcionesAuxiliares.esperarElemento(winiumDriver,corteCaja.btnAceptarNotificacion,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,corteCaja.btnAceptarNotificacion,15);

    }
    @Dado("se muestra el login")
    public void se_muestra_el_login() {
        try {
            Thread.sleep(15000);
            allure.capturaAllure(winiumDriver);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
