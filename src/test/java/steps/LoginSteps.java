package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.openqa.selenium.winium.WiniumDriver;
import pages.Login;
import pages.PaginaPrincipal;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;

public class LoginSteps {

    public LoginSteps(){

    }

    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private Login login = new Login();
    private ReporteAllure allure = new ReporteAllure();
    private PaginaPrincipal paginaPrincipal = new PaginaPrincipal();

    @Dado("que me encuentro en la aplicación FarMax")
    public void que_me_encuentro_en_la_aplicacion_FarMax(){
        funcionesAuxiliares.esperarElemento(winiumDriver,login.usuario,25);
        allure.capturaAllure(winiumDriver);
    }

    @Y("escribo las credenciales del perfil MF {string} {string}")
    public void escribo_las_credenciales_del_perfil_MF(String usuario,String password){
        funcionesAuxiliares.enviarDatos(winiumDriver,login.usuario,usuario,10);
        funcionesAuxiliares.enviarDatos(winiumDriver,login.password,password,10);
        allure.capturaAllure(winiumDriver);
    }

    @Y("doy click en Aceptar")
    public void doy_click_en_Aceptar(){
        funcionesAuxiliares.click(winiumDriver,login.btnLogin,10);
        funcionesAuxiliares.click(winiumDriver,paginaPrincipal.btnContinuarCajaInicial,20);
        allure.capturaAllure(winiumDriver);
    }
}
