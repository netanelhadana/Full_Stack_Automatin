package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// Class To identifying Elements
public class mainPage
{
    @FindBy(how = How.XPATH, using = "//h1[@class='css-jjwbqw']")
    public WebElement txt_mainHeading;

}
