package PageObjects.ElectronDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// Class To identifying Elements
public class mainPage
{
    @FindBy(how = How.ID, using = "button-app-sys-information")
    public WebElement btn_information;

    @FindBy(how = How.ID, using = "button-windows")
    public WebElement btn_window;

    @FindBy(how = How.ID, using = "screen-info-demo-toggle")
    public WebElement btn_demo_toggle;

    @FindBy(how = How.ID, using = "screen-info")
    public WebElement btn_screen_info;

    @FindBy(how = How.ID, using = "got-screen-info")
    public WebElement field_screen_info;

}
