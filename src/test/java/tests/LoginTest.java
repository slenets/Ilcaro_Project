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

    @BeforeMethod
    public void logOut(){
        if(app.userHelper().isElementPresent(By.xpath("//a[text()=' Logout ']"))){
            app.userHelper().logout();
        }
    }

    @Test
    public void loginSuccess(){
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("slavka.lenetz@gmail.com", "Ilcarro123");
        app.userHelper().submitLoginForm();
        Assert.assertTrue(app.userHelper().isLogged(".dialog-container h2"));
    }

    @Test
    public void loginSuccessModel(){
        User user = new User().withPassword("Ilcarro123")
                        .withEmail("slavka.lenetz@gmail.com");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLoginForm();
        Assert.assertTrue(app.userHelper().isLogged(".dialog-container h2"));
    }

    @Test
    public void negativeLoginWrongPassword(){
        User user = new User().withEmail("slavka.lenetz@gmail.com").withPassword("lcarro1234");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLoginForm();
        Assert.assertFalse(app.userHelper().isLogged(".dialog-container h2"));

    }

    @AfterMethod
    public void postCondition(){
        if(app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }
}
