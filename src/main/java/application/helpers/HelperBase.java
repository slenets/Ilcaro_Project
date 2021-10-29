package application.helpers;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void waitForElement(By selector){
        WebElement el = wd.findElement(selector);
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void typeTextBox(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submitYalla() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isYallaButtonActive() {
        return wd.findElement(By.xpath("//button[@type='submit']")).isSelected();
        //return isElementPresent(By.xpath("//button[@disabled]"));
    }

    public void takeScreenShot(String pathToFile){
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

        File screenShot = new File(pathToFile);
        try{
            Files.copy(tmp, screenShot);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void fillLoginForm(String email, String password) {
        typeTextBox(By.xpath("//input[@formcontrolname='email']"), email);
        typeTextBox(By.xpath("//input[@formcontrolname='password']"), password);
    }



}
