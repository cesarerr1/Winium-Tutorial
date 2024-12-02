package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.openqa.selenium.winium.WiniumDriver;
import pages.Login;
import pages.PaginaPrincipal;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;

public class RecepcionesSteps {

    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private Login login = new Login();
    private PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private ReporteAllure allure = new ReporteAllure();

    @Dado("doy click en recepciones")
    public void doy_click_en_recepciones() {
        funcionesAuxiliares.esperarElemento(winiumDriver,login.btnRecepciones,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,login.btnRecepciones,15);
    }
    @Dado("doy click en el menu principal")
    public void doy_click_en_el_menu_principal() {
        funcionesAuxiliares.esperarElemento(winiumDriver,paginaPrincipal.menuPrincipal,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,paginaPrincipal.menuPrincipal,15);
    }

    @Y("uso el atajo de teclas {string} + {string}")
    public void usoElAtajoDeTeclas(String key1, String key2) {
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.atajoTeclas(key1,key2);
    }


}
