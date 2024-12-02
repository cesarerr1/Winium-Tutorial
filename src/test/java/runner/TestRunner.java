package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RecepcionesRunner.class,
        LoginRunner.class,
        ServiciosRunner.class,
        RecetaRunner.class,
        CotizacionesRunner.class,
        VentaRunner.class,
        DonativoRunner.class,
        CorteCajaRunner.class
})

public class TestRunner {


}
