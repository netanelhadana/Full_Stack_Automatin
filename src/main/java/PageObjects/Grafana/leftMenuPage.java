package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// Class To identifying Elements
public class leftMenuPage
{
    @FindBy(how = How.XPATH,using = "//div[@class='sidemenu-item dropdown'][6]")
    public WebElement btn_serverAdmin;

    @FindBy(how = How.XPATH,using = "//span[@class='icon-circle sidemenu-icon']/img")
    public WebElement imageAvatar;

    @FindBy(how = How.XPATH,using = "(//div[@class='sidemenu-item dropdown dropup'])[1]")
    public WebElement btn_admin;

}
