package steps;

import core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CalculadoraPage;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class CalculadoraSteps {

    CalculadoraPage calculadoraPage;

    @Before
    public void inicializaApp(Scenario scenario) throws MalformedURLException {
        new Driver("Android", "Nexus 4 API 28", "uiautomator2",
                "com.android.calculator2", "com.android.calculator2.Calculator");
        System.out.println("Cenario: " + scenario.getName());
    }


    @Dado("que estou na tela principal")
    public void queEstouNaTelaPrincipal() {
        calculadoraPage = new CalculadoraPage();
    }
//
//    @Quando("insiro os valores")
//    public void insiroOsValores(Map<String, String> map) {
//
//        boolean valor1 = Boolean.parseBoolean(map.get("valor1"));
//        boolean valor2 = Boolean.parseBoolean(map.get("valor2"));
//        calculadoraPage.setNumbers(valor1);
//        calculadoraPage.setNumbers(valor2);
//
//    }
//
//    @Entao("deve ser exibido o resultado na tela")
//    public void deveSerExibidoOResultadoNaTela(Map<String, String> map) {
//        String resultado = calculadoraPage.getResult(map.get("resultado"));
//
//        assertEquals(resultado, calculadoraPage.getResult(map.get("resultado")));
//    }

    @Quando("insiro os valores {string} e {string}")
    public void insiroOsValoresE(String valor1, String valor2) {
        calculadoraPage.setNumbers(Boolean.parseBoolean(valor1));
        calculadoraPage.clickMultiplicar();
        calculadoraPage.setNumbers(Boolean.parseBoolean(valor2));

    }

    @E("clicar em igual")
    public void clicarEmIgual() {
        calculadoraPage.clickEqual();
    }

    @Entao("deve ser exibido o resultado {string}")
    public void deveSerExibidoOResultado(String resultado) {
        String resposta = calculadoraPage.getResult(resultado);

        assertEquals(resposta, calculadoraPage.getResult(resultado));
    }


    @After
    public void fechaApp(Scenario scenario) {
        System.out.println("Status: " + scenario.getStatus());
        Driver.getDriver().quit();
    }

}
