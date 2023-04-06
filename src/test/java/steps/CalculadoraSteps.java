package steps;

import core.DriverFactory;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CalculadoraPage;

import static org.junit.Assert.assertEquals;

public class CalculadoraSteps {

    CalculadoraPage calculadoraPage;


    @Dado("que estou na tela principal")
    public void queEstouNaTelaPrincipal() throws Exception {
        try {
            calculadoraPage = new CalculadoraPage();
            DriverFactory.printScreenshot("que estou na tela principal");
        } catch (Exception e) {
            throw new Exception("Não estou na tela principal");
        }

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
    public void insiroOsValoresE(String valor1, String valor2) throws Exception {
        try {
            calculadoraPage.setNumbers(Boolean.parseBoolean(valor1));
            calculadoraPage.clickMultiplicar();
            calculadoraPage.setNumbers(Boolean.parseBoolean(valor2));
            DriverFactory.printScreenshot("insiro os valores");
        } catch (Exception e) {
            throw new Exception("não foi inserido os valores");
        }


    }

    @E("clicar em igual")
    public void clicarEmIgual() throws Exception {
        try {
            calculadoraPage.clickEqual();
            DriverFactory.printScreenshot("clicar em igual");
        } catch (Exception e) {
            throw new Exception("Não clicou em Igual");
        }

    }

    @Entao("deve ser exibido o resultado {string}")
    public void deveSerExibidoOResultado(String resultado) throws Exception {
        try {
            String resposta = calculadoraPage.getResult();
            assertEquals(resultado, resposta);
            DriverFactory.printScreenshot("deve ser exibido o resultado");
        } catch (Exception e) {
            throw new Exception("Não foi exibido o resultado");
        }

    }


}
