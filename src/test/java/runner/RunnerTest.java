package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"json:target/report/cucumber.json","html:target/report.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@multiplicar"
)
public class RunnerTest {
    @AfterClass
    public static void report() throws IOException {
        if (System.getProperty("os.name").equals("Windows 10")) {
            Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
        } else {
            Runtime.getRuntime().exec("sh -c mvn cluecumber-report:reporting");
        }
        GeraRelatorio.gerar();
    }
}
