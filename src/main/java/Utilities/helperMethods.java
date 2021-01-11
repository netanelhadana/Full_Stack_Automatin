package Utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

public class helperMethods extends commonOps
{
    public static void takeElementScreenShot(WebElement imageElement, String imageName)
    {
//        imageScreenShot = new AShot().coordsProvider((new WebDriverCoordsProvider().takeScreenshot(driver,imageElement))); //for win10
//          imageScreenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        imageScreenShot = new AShot().takeScreenshot(driver,imageElement); //for win7
        try
        {
            ImageIO.write(imageScreenShot.getImage(), "png", new File( getData("ImageRepo") + imageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error writing image file, see details: " + e);
        }
    }
}
