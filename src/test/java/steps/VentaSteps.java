package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.openqa.selenium.winium.WiniumDriver;
import pages.DemandaArticulos;
import pages.MonederoAhorro;
import pages.PaginaPrincipal;
import pages.Venta;
import utils.FuncionesAuxiliares;
import utils.ReporteAllure;
import utils.WiniumDriverManager;

public class VentaSteps {

    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();
    private Venta venta = new Venta();
    private DemandaArticulos demandaArticulos = new DemandaArticulos();
    private MonederoAhorro monederoAhorro = new MonederoAhorro();
    private ReporteAllure allure = new ReporteAllure();
    private PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    private WiniumDriver winiumDriver = WiniumDriverManager.runDriver();

    @Dado("que busco el producto {string}")
    public void queBuscoElProducto(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,paginaPrincipal.SKU,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,paginaPrincipal.SKU,arg0,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.atajoTeclas("ENTER");
    }

    @Y("doy click en cancelar monedero")
    public void doyClickEnCancelarMonedero() {
        if(funcionesAuxiliares.esperarElemento(winiumDriver,monederoAhorro.textMonederoVentana,15)){
            allure.capturaAllure(winiumDriver);
            funcionesAuxiliares.click(winiumDriver,monederoAhorro.btnCancelar,15);
        }

    }

    @Y("presiono {string}")
    public void presiono(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,venta.producto,15);
        funcionesAuxiliares.atajoTeclas(arg0);
    }

    @Y("doy click en cancelar informacion del medico")
    public void doyClickEnCancelarInformacionDelMedicoYCancelarDonativo() {
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,venta.btnCancelarNotificacion,15);


    }

    @Y("cancelar donativo")
    public void cancelarDonativo() {
        if(funcionesAuxiliares.esperarElemento(winiumDriver,venta.ventanaDonativo,30)){
            allure.capturaAllure(winiumDriver);
            funcionesAuxiliares.click(winiumDriver,venta.btnCancelarNotificacion,15);
        }else{
            allure.capturaAllure(winiumDriver);
            funcionesAuxiliares.atajoTeclas("ENTER");
        }

    }


    @Y("escribo {string} de efectivo")
    public void escriboDeEfectivo(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,venta.editTextEfectivo,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,venta.editTextEfectivo,arg0,15);
        allure.capturaAllure(winiumDriver);
    }

    @Y("presiono {string} para procesar el pago")
    public void presionoParaProcesarElPago(String arg0) {
        funcionesAuxiliares.atajoTeclas(arg0);
    }

    @Y("se muestran los detalles de la venta")
    public void seMuestranLosDetallesDeLaVenta() {
        try {
            Thread.sleep(4000);
            allure.capturaAllure(winiumDriver);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Y("doy click en filtrar por {string}")
    public void doyClickEnFiltrarPor(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,demandaArticulos.ltFiltros,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,demandaArticulos.ltFiltros,arg0,15);
        funcionesAuxiliares.atajoTeclas("ENTER");
        allure.capturaAllure(winiumDriver);
    }

    @Y("escribo el sku {string}")
    public void escriboElSku(String arg0) {
        funcionesAuxiliares.esperarElemento(winiumDriver,demandaArticulos.tbBusqueda,15);
        funcionesAuxiliares.enviarDatos(winiumDriver,demandaArticulos.tbBusqueda,arg0,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.atajoTeclas("ENTER");
        funcionesAuxiliares.esperarElemento(winiumDriver,demandaArticulos.txEstatus,15);

    }

    @Y("doy click en aceptar demanda")
    public void doyClickEnAceptarDemanda() {
        funcionesAuxiliares.esperarElemento(winiumDriver,demandaArticulos.btnAceptar,15);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,demandaArticulos.btnAceptar,15);
        funcionesAuxiliares.click(winiumDriver,demandaArticulos.btnAceptarConfirmacion,15);
    }

    @Y("se muestra el stock del producto")
    public void seMuestraElStockDelProducto() throws InterruptedException {
        Thread.sleep(3000);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.click(winiumDriver,demandaArticulos.btnCerrar,15);
        funcionesAuxiliares.click(winiumDriver,demandaArticulos.btnAceptarConfirmacion,15);
    }

    @Y("presiono {string} para pagar por vales")
    public void presionoParaPagarPorVales(String arg0) {
        funcionesAuxiliares.atajoTeclas(arg0);
        allure.capturaAllure(winiumDriver);
    }

    @Y("escribo {string} de pago en vales")
    public void escriboDePagoEnVales(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        funcionesAuxiliares.escribirTexto(arg0);
        allure.capturaAllure(winiumDriver);
    }

    @Y("selecciono {string}, escribo {string} y {string}")
    public void seleccionoEscriboY(String arg0, String arg1, String arg2) throws InterruptedException {
        funcionesAuxiliares.escribirTexto(arg0);
        Thread.sleep(2000);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg1);
        Thread.sleep(2000);
        funcionesAuxiliares.atajoTeclas("TAB");
        funcionesAuxiliares.escribirTexto(arg2);
        Thread.sleep(2000);
        allure.capturaAllure(winiumDriver);
        funcionesAuxiliares.atajoTeclas("ENTER");
    }
}
