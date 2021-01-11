package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class adminMenuPage
{
    //a[href='/logout']
    @FindBy(how = How.CSS ,using = "a[href='/logout']")
    public WebElement btn_logout;
}
