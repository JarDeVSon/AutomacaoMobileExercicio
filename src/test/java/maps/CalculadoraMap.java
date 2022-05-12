package maps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalculadoraMap {

    @AndroidFindBy(id = "digit_7")
    public MobileElement touchNumbers;
    @AndroidFindBy(id = "op_mul")
    public MobileElement touchMultiplicar;
    @AndroidFindBy(id = "eq")
    public MobileElement touchEqual;
    @AndroidFindBy(id = "result")
    public MobileElement result;

}
