package tests;

import application.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
       app.init();
    }

    @AfterSuite
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
