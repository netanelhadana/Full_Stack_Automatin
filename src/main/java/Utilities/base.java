package Utilities;

import PageObjects.Mortgage.mainPage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//Define objects that will serve us throughout the project
public class base
{

    //This drivers will be familiar everywhere
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static String Platform;


    public static PageObjects.Grafana.loginPage grafanaLogin;
    public static PageObjects.Grafana.mainPage grafanaMain;
    public static PageObjects.Grafana.leftMenuPage grafanaLeftMenu;
    public static PageObjects.Grafana.serverAdminMenuPage grafanaServerAdminMenuPage;
    public static PageObjects.Grafana.serverAdminMainPage grafanaServerAdminMainPage ;
    public static PageObjects.Grafana.addNewUserPage grafanaAddNewUser ;
    public static PageObjects.Grafana.adminMenuPage grafanaAdminMenuPage ;

    public static PageObjects.Mortgage.mainPage mortgageMain;
    public static PageObjects.ElectronDemo.mainPage electronMain;
    public static PageObjects.calculator.mainPage calcMain;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JsonPath jp;
    public static JSONObject requestParams = new JSONObject();

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;


}
