package maps;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class CalculadoraMap {

    @AndroidFindBy(id = "digit_7")
    @iOSXCUITFindBy(id = "digit_7")
    public RemoteWebElement touchNumbers;
    @AndroidFindBy(id = "op_mul")
    @iOSXCUITFindBy(id = "op_mul")
    public RemoteWebElement touchMultiplicar;
    @AndroidFindBy(id = "eq")
    @iOSXCUITFindBy(id = "eq")
    public RemoteWebElement touchEqual;
    @AndroidFindBy(id = "result")
    @iOSXCUITFindBy(id = "result")
    public RemoteWebElement result;

}
