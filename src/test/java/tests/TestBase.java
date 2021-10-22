package tests;

import application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME)); // for terminal syntax

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m){
        logger.info("Start method: " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m){
        logger.info("End of test --> " + m.getName());
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
       app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    //************************************** Test Methods Implementation ****************************************







    //**************************** Registration ********************************************

//    public void deleteAccount(){
//        click(By.xpath("//a[text()='Delete account']"));
//        click(By.xpath("//button[text()='Delete']"));
//    }
//
//    public boolean isDeleteAccountPresent(){
//        return isElementPresent(By.xpath("//a[text()='Delete account']"));
//    }
//
//    public boolean isRegistered(String value){
//        String text = wd.findElement(By.cssSelector(value)).getText();
//        click(By.xpath("//button[text()='Ok']"));
//        return text.equals("You are logged in success");
//    }
//
//    public void openRegistrationForm(){
//        click(By.xpath("//*[contains(@href, '/registration?url=%2Fsearch')]"));
//    }
//
//    public void fillRegistrationForm(String name, String lastName, String email, String password){
//        typeTextBox(By.id("name"), name);
//        typeTextBox(By.id("lastName"), lastName);
//        typeTextBox(By.id("email"), email);
//        typeTextBox(By.id("password"), password);
//    }
//
//    public void fillCheckBox(){
//        click(By.xpath("//input[@type='checkbox']"));
//    }
//
//    public void submitRegistrationForm(){
//        click(By.xpath("//button[@type='submit']"));
//    }












}
