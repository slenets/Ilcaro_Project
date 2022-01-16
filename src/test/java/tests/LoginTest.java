package tests;

import application.dataprovider.MyDataProvider;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.userHelper().isElementPresent(By.xpath("//a[text()=' Logout ']"))){
            app.userHelper().logout();
        }
    }

    @Test(enabled = false, dataProvider = "validDataLoginClass", dataProviderClass = MyDataProvider.class)
    public void positiveLogin(String email, String password){
        logger.info("Login with email: slavka.lenetz@gmail.com &  password Ilcarro123");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(email, password);
        app.userHelper().submitLoginForm();
        app.userHelper().pause(1000);
        Assert.assertTrue(app.userHelper().isLogged());

    }



    @Test(dataProvider = "dataLoginCSV", dataProviderClass = MyDataProvider.class)
    public void loginSuccessModel(User user){
//        User user = new User().withPassword("Ilcarro123") //Ilcarro123
//                        .withEmail("slavka.lenetz@gmail.com"); //slavka.lenetz@gmail.com

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLoginForm();
        //app.userHelper().takeScreenShot("C:\\Qa29\\Ilcaro_Project\\src\\test\\screenshots");
        app.userHelper().pause(2000);
        Assert.assertTrue(app.userHelper().isLogged());
    }

    @Test
    public void negativeLoginEmptyEmail(){
        User user = new User().withEmail("").withPassword("Ilcarro123");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        Assert.assertTrue(app.userHelper().isEmptyEmailWarning() && !app.userHelper().isYallaButtonActive());
    }

    @Test
    public void negativeLoginEmptyPassword(){
        User user = new User().withEmail("slavka.lenetz@gmail.com");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().pause(1000);
        app.userHelper().clickEmailField();
        Assert.assertTrue(app.userHelper().isEmptyPasswordWarning() && !app.userHelper().isYallaButtonActive());
    }

    @Test
    public void negativeLoginEmptyBothFields(){
        app.userHelper().openLoginForm();
        app.userHelper().clickEmailField();
        app.userHelper().clickPasswordField();
        app.userHelper().clickEmailField();
        Assert.assertTrue(app.userHelper().isEmptyEmailWarning() && app.userHelper().isEmptyPasswordWarning() && !app.userHelper().isYallaButtonActive());
    }

    @Test
    public void negativeLoginWrongEmail(){
        User user = new User().withEmail("slava.lenetz@gmail.com").withPassword("Ilcarro123");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLoginForm();
        Assert.assertFalse(app.userHelper().isLogged());
    }


    @Test
    public void negativeLoginWrongPassword(){
        User user = new User().withEmail("slavka.lenetz@gmail.com").withPassword("lcarro123");
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
