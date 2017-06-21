package Cukes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        glue = {"classpath:Interview"},

        features = "src\\test\\java\\Feature",
        strict = true,
        tags = {"@onlineShopping"})
public class TestRunnerShopping {
    @BeforeClass
    public static void loadProperties() throws IOException {

    }
}