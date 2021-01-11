package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class verifications extends commonOps
{
    @Step("Verify Text in Element")
    public static void textInElement(WebElement elem, String expectedValue)
    {
        if (!Platform.equalsIgnoreCase("mobile") && !Platform.equalsIgnoreCase("electron") && !Platform.equalsIgnoreCase("desktop"))
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        if (Platform.equalsIgnoreCase("desktop"))
            assertEquals(elem.getText().replaceAll("התצוגה היא", "").trim(),expectedValue);
        else
            assertEquals(elem.getText(),expectedValue);
    }

    @Step("Verify the Number of Elements Equals to")
    public static void numberOfElements(List<WebElement> elems, int expectedValue)
    {
        if (!Platform.equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),expectedValue);
    }

    @Step("Verify visual element")
    public static void visualElement(WebElement imageElem, String ExpectedImageName)
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("ImageRepo") + ExpectedImageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file, see details: " + e);
        }
        Screenshot imageScreenShot = new AShot().takeScreenshot(driver, imageElem);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = imgDiff.makeDiff(actualImage,expectedImage);
        assertFalse(diff.hasDiff(),"images are not the same");
    }

    @Step("Verify text with text")
    public static void text(String actualText, String expectedText)
    {
        assertEquals(actualText, expectedText);
    }

}
