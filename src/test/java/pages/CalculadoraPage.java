package pages;

import core.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import maps.CalculadoraMap;
import org.openqa.selenium.support.PageFactory;

public class CalculadoraPage {
    CalculadoraMap calculadoraMap;

    public CalculadoraPage(){
        calculadoraMap = new CalculadoraMap();
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),calculadoraMap);
    }


    public void clickEqual(){
        calculadoraMap.touchEqual.click();
    }
    public String getResult(String resultado) {
        return calculadoraMap.result.getText();
    }
    public void clickMultiplicar(){
        calculadoraMap.touchMultiplicar.click();
    }
    public boolean setNumbers(boolean valor1){
      return calculadoraMap.touchNumbers.isSelected();
    }

}
