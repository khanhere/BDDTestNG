package testng1;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import testng1.pageobjects.SauceLabsLogin;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Setupclass {

/*
    @Before
    public static void openbrowser()
    {

        //File file = new File("driver/chromedriver.exe");
       // System.setProperty("webdriver.htmlunit.driver", file.getAbsolutePath());
        //SauceLabsLogin.driver = new ChromeDriver();

        SauceLabsLogin.driver=new HtmlUnitDriver();

        SauceLabsLogin.driver.manage().window().maximize();
        SauceLabsLogin.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @After
    public static void tearDown(){
        SauceLabsLogin.driver.quit();

    }
*/

}
