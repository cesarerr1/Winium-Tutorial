package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CorteCajaRunner.class, CotizacionesRunner.class, DonativoRunner.class, LoginRunner.class, RecepcionesRunner.class, RecetaRunner.class, RecetasRunner.class, ServiciosRunner.class, VentaRunner.class
})
public class TestRunner {

}