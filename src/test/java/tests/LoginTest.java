package tests;

import application.ApplicationManager;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;

public class LoginTest extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.userHelper().isElementPresent(By.xpath("//a[text()=' Logout ']"))){
            app.userHelper().logout();
        }
    }

    @Test(groups = {"web"})
    public void loginSuccess(){
        logger.info("Login with email: slavka.lenetz@gmail.com &  password Ilcarro123");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("slavka.lenetz@gmail.com", "Ilcarro123");
        app.userHelper().submitLoginForm();
        Assert.assertTrue(app.userHelper().isLogged());

    }

    @Test
    public void loginSuccessModel(){
        User user = new User().withPassword("Ilcarro123")
                        .withEmail("slavka.lenetz@gmail.com");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLoginForm();
        Assert.assertTrue(app.userHelper().isLogged());
    }

    @Test
    public void negativeLoginWrongPassword(){
        User user = new User().withEmail("slavka.lenetz@gmail.com").withPassword("lcarro1234");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLoginForm();
        Assert.assertFalse(app.userHelper().isLogged());

    }

    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        app.userHelper().clickOkButton();
    }
}
