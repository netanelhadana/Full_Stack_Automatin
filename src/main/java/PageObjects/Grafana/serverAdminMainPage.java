package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

// Class To identifying Elements
public class serverAdminMainPage
{
    @FindBy(how = How.XPATH ,using = "//table[@class='filter-table form-inline filter-table--hover']/tbody/tr")
    public List<WebElement> rows;

    @FindBy(how = How.CSS, using = "a[class='css-u6ysb0-button']")
    public WebElement btn_newUser;
}
