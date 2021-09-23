package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    HelperCar carHelper;

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        carHelper  = new HelperCar(wd);
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
}
