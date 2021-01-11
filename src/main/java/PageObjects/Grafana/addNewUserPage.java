package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// Class To identifying Elements
public class addNewUserPage
{
    @FindBy(how = How.CSS, using = "input[name='name']")
    public WebElement txt_name;

    @FindBy(how = How.CSS, using = "input[name='email']")
    public WebElement txt_email;

    @FindBy(how = How.CSS, using = "input[name='login']")
    public WebElement txt_userName;

    @FindBy(how = How.CSS, using = "input[name='password']")
    public WebElement txt_password;

    @FindBy(how = How.CSS, using = "button[class='css-u6ysb0-button']")
    public WebElement btn_create;

    @FindBy(how = How.CSS, using = "button[class='css-1scyk9l-button']")
    public WebElement btn_deleteUser;

    @FindBy(how = How.XPATH, using = "//div[@class='css-1nrg97p']/button[@class='css-1scyk9l-button']")
    public WebElement btn_confirmDelete;
}
