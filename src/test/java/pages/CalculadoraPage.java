package pages;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import maps.CalculadoraMap;
import org.openqa.selenium.support.PageFactory;
import core.DriverFactory;




public class CalculadoraPage {
    CalculadoraMap calculadoraMap;

    public CalculadoraPage(){
        calculadoraMap = new CalculadoraMap();
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()),calculadoraMap);
    }


    public void clickEqual(){
        calculadoraMap.touchEqual.click();
    }
    public String getResult() {
        return calculadoraMap.result.getText();
    }
    public void clickMultiplicar(){
        calculadoraMap.touchMultiplicar.click();
    }
    public void setNumbers(boolean bool){
        calculadoraMap.touchNumbers.click();
    }

}
