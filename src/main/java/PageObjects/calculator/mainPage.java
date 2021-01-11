package PageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// Class To identifying Elements
public class mainPage
{
    @FindBy(how = How.NAME, using = "נקה")
    public WebElement btn_clear;

    @FindBy(how = How.NAME, using = "אחת")
    public WebElement btn_one;

    @FindBy(how = How.NAME, using = "ועוד")
    public WebElement btn_plus;

    @FindBy(how = How.NAME, using = "חמש")
    public WebElement btn_five;

    @FindBy(how = How.NAME, using = "שווה")
    public WebElement btn_equals;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement btn_calculatorResults;
}
