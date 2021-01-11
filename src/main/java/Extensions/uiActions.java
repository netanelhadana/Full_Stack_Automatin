package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// Class that Covers the Action of Selenium
public class uiActions extends commonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron") && !Platform.equalsIgnoreCase("desktop"))
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Send text To Text Field")
    public static void updateText(WebElement elem, String value)
    {
        if (!Platform.equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(value);
    }

    @Step("Select From Drop Down Field")
    public static void updateDropDown(WebElement elem, String value)
    {
        if (!Platform.equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        Select myValue = new Select(elem);
        myValue.selectByVisibleText(value);
    }

    @Step("Mouse Over to Element")
    public static void mouseHoverElements(WebElement elem1, WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Click on Element")
    public static void listClick(List<WebElement> elem, int number)
    {
        elem.get(number).click();
    }

    @Step("Clear the Element")
    public static void clear(WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
    }

    @Step("Drag and Drop Element")
    public static void dragAndDropElement(WebElement drag, WebElement drop ){
        action.dragAndDrop(drag,drop).build().perform();
    }

    @Step("Select Multiple Options ")
    public void select_Multiple(List<WebElement> listItems, int indexOfElement1, int indexOfElement2)
    {
        action.clickAndHold(listItems.get(indexOfElement1)).clickAndHold(listItems.get(indexOfElement2)).click().build().perform();
    }

    @Step("Double click on Element")
    public void double_Click(WebElement elem)
    {
        action.doubleClick(elem).build().perform();
    }

    @Step("Scroll on the site")
    public void Scroll(WebElement elem)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    @Step("Get Number of Elements")
    public static void getNumberOfElements(List<WebElement> elems)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elems.get(elems.size()-1)));
        WebElement d = elems.get(elems.size()-1);
        String g = d.getText();
        System.out.println(g);
    }

    @Step("Get Current Date")
    public static void currentDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date);
    }

}
