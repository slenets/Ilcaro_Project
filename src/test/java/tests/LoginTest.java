package tests;

import application.ApplicationManager;
import application.MyDataProvider;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;

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

    @DataProvider
    public Iterator<Object[]> validDataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"slavka.lenetz@gmail.com","Ilcarro123"});
        list.add(new Object[]{"slavka.lenetz@gmail.com","Ilcarro123"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});

      return list.iterator();
    }


    @Test(dataProvider = "validDataLoginClass", dataProviderClass = MyDataProvider.class)
    public void loginSuccess(String email, String password){
        logger.info("Login with email: slavka.lenetz@gmail.com &  password Ilcarro123");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(email, password);
        app.userHelper().submitLoginForm();
        Assert.assertTrue(app.userHelper().isLogged());

    }

    @DataProvider
    public Iterator<Object[]> dataLoginCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] strs = line.split(",");
            list.add(new Object[]{new User().withEmail(strs[0]).withPassword(strs[1])});
            line= reader.readLine();
        }

        return list.iterator();

    }

    @Test(dataProvider = "dataLoginCSV")
    public void loginSuccessModel(User user){
//        User user = new User().withPassword("Ilcarro123") //Ilcarro123
//                        .withEmail("slavka.lenetz@gmail.com"); //slavka.lenetz@gmail.com

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLoginForm();
        //app.userHelper().takeScreenShot("C:\\Qa29\\Ilcaro_Project\\src\\test\\screenshots");
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
