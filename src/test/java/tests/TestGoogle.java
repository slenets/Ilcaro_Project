package tests;

import application.listeners.ListenerNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerNG.class)
public class TestGoogle {
    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
    }

    @Test
    public void openGoogle(){
        wd.navigate().to("https://www.google.com");
    }

    @AfterMethod
    public void stop(){
        wd.quit();
    }

}
