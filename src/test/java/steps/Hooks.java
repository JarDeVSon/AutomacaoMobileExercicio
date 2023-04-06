package steps;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void inicializaApp(Scenario scenario) throws MalformedURLException {
        new DriverFactory("",
                "Android",
                "Nexus 4 API 28",
                "uiautomator2",
                "com.android.calculator2",
                "com.android.calculator2.Calculator",
                false);
        DriverFactory.setNameScenario(scenario.getName());
        DriverFactory.makeDirectory();
        System.out.println("Cenario: " + scenario.getName());

    }

    @After
    public void fechaApp(Scenario scenario) throws IOException {
        System.out.println("Cenario: " + scenario.getName() + " | Status: " + scenario.getStatus());
        if (scenario.isFailed()){
            DriverFactory.printScreenshot("This step failed");
        }
        DriverFactory.getDriver().quit();
    }
}
