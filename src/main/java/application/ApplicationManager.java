package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper userHelper;
    HelperCar carHelper;
    SearchHelper searchHelper;
    RentHelper rent;
    String browser;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        this.properties = new Properties();
    }

    public SearchHelper getSearchHelper() {
        return searchHelper;
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "data");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }
        wd.register(new MyListener());

        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        carHelper  = new HelperCar(wd);
        searchHelper = new SearchHelper(wd);
        rent = new RentHelper(wd);
    }

    public void stop(){
        //wd.quit();
    }

    public UserHelper userHelper() {
        return userHelper;
    }

    public HelperCar carHelper() {
        return carHelper;
    }

    public RentHelper rentHelper() {
        return rent;
    }
}
