package testng1;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.*;
import testng1.pageobjects.SauceLabsLogin;
import cucumber.api.testng.PickleEventWrapper;

import java.io.File;
import java.util.concurrent.TimeUnit;

@CucumberOptions(features = "src/test/resources/testng1/testngf1.feature",tags = {"@login1"},
        format = { "pretty",
                "html:target/site/cucumber-pretty",
                "rerun:target/rerun.txt",
                "json:target/cucumber1.json" })
public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public static void openbrowser()
    {

        File file = new File("driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        SauceLabsLogin.driver = new ChromeDriver();
//Enable only below line to perform with HTML Unit driver, comment above lines
        //SauceLabsLogin.driver=new HtmlUnitDriver();

        SauceLabsLogin.driver.manage().window().maximize();
        SauceLabsLogin.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

@Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable{
    testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
}
    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    /*
    @Test(groups = "examples-testng", description = "Example of using TestNGCucumberRunner to invoke Cucumber")
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
*/

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
    @AfterSuite
    public static void tearDown(){
        SauceLabsLogin.driver.quit();

    }








}
