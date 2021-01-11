package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// Class To identifying Elements
public class loginPage
{
    @FindBy(how = How.NAME, using = "user")
    public WebElement txt_userName;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.CLASS_NAME, using = "css-6ntnx5-button")
    public WebElement btn_login;

    @FindBy(how = How.CLASS_NAME, using = "css-1mej2rr-button")
    public WebElement btn_Skip;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-warning']")
    public WebElement alert_message;

}
