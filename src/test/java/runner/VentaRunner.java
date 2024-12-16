package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/Venta.feature",
    glue = {"steps"},
    monochrome = true,
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    tags = ""
)
public class VentaRunner extends AllureJunit4 {
}