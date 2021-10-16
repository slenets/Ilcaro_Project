package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
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




}
