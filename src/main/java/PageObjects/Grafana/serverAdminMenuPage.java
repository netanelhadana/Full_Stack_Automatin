package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// Class To identifying Elements
public class serverAdminMenuPage
{
    @FindBy(how = How.CSS ,using = "a[href='/admin/users']")
    public WebElement link_users;

    @FindBy(how = How.CSS ,using = "a[href='/admin/orgs']")
    public WebElement link_orgs;

    @FindBy(how = How.CSS ,using = "a[href='/admin/settings']")
    public WebElement link_settings;

    @FindBy(how = How.CSS ,using = "a[href='/admin/stats']")
    public WebElement link_stats;

    @FindBy(how = How.CSS ,using = "a[href='/admin/upgrading']")
    public WebElement link_upgrading;


}
