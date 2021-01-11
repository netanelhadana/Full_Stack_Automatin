package Utilities;

import Extensions.excelActions;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

// Class that services the other classes
public class commonOps extends base
{
    @DataProvider(name = "loginData")
    public Object[][] getData()
    {
        Object data[][] = testData();
        return data;
    }

    public static Object[][] testData()
    {
        int rowCount = excelActions.getRowCount();
        int colCount = excelActions.getColumnCount();

        Object data[][] = new Object[rowCount-1][colCount];
        for (int i=1; i<rowCount; i++)
        {
            for (int j=0; j<colCount; j++)
            {
                String cellData = excelActions.getCellDataString(i,j);
                //System.out.print(cellData+" | ");
                data[i-1][j] = cellData;
            }
            //System.out.println();
        }
        return data;
    }

    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    // Browser initialization Method
    public void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else  if (browserType.equalsIgnoreCase("fireFox"))
            driver = initFFDriver();
        else  if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException(("invalid platform name stated"));
        driver.manage().window().maximize();
        driver.get(getData("URL"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
    }

    // Driver initialization Method that returns an object of WebDriver Type
    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    // Driver initialization Method that returns an object of WebDriver Type
    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    // Driver initialization Method that returns an object of WebDriver Type
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try
        {
            driver = new RemoteWebDriver(new URL(getData("AppiumServer") + "/wd/hub"), dc);
        }
        catch (Exception e)
        {
            System.out.println("Can not connect to appium Server, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
    }

    public static void initAPI()
    {
        RestAssured.baseURI = getData("URL_api");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("user"),getData("password"));
    }

    public static void initElectron()
    {
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
    }

    public static void initDesktop()
    {
        dc.setCapability("app",getData("calculatorApp"));
        try
        {
            driver = new WindowsDriver(new URL(getData("AppiumServer")),  dc);
        }
        catch (Exception e)
        {
            System.out.println("Can not connect to appium Server, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);

    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName)
    {
        Platform = PlatformName;
        if (Platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (Platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (Platform.equalsIgnoreCase("api"))
            initAPI();
        else if (Platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (Platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException(("invalid Platform name stated"));
        managePages.init();
        manageDB.initConnection(getData("dbURL"),getData("dbUser"),getData("dbPassword"));
    }

//    @AfterMethod
//    public void afterMethod()
//    {
//        driver.get(getData("URL"));
//    }

    @AfterMethod
    public void afterSession()
    {
        if (Platform.equalsIgnoreCase("web"))
        driver.get(getData("URL"));
    }

    @AfterClass
    public void closeSession()
    {
        manageDB.closeConnection();
        if (!Platform.equalsIgnoreCase("api"))
        driver.quit();
    }


}
