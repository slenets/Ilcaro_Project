package application.helpers;

import application.helpers.HelperBase;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RentHelper extends HelperBase {

    public RentHelper(WebDriver wd) {
        super(wd);
    }

    public void open50items(){
        click(By.className("mat-select-value"));
        click(By.xpath("//span[text()=' 50 ']"));
    }


    public void selectCarAndRent() {
        List<WebElement> elementList = wd.findElements(By.className("car-container"));
        int size = elementList.size();
        int i = 1;

        while (size > 0) {
            click(By.cssSelector(String.format(".car-container:nth-child(%s)", i++)));
            if (wd.findElement(By.xpath("//button[text()='Rent now!! ']")).isEnabled()) {
                clickRentNow();
                break;
            } else {
                wd.navigate().back();
                System.out.println(i);
                size--;
            }
        }

    }

    public void selectCarAndRent(String email, String password) {
        List<WebElement> elementList = wd.findElements(By.className("car-container"));
        int size = elementList.size();
        int i = 1;

        while (size > 0) {
            click(By.cssSelector(String.format(".car-container:nth-child(%s)", i++)));
            if (wd.findElement(By.xpath("//button[text()='Rent now!! ']")).isEnabled()) {
                clickRentNow();
                if(loginIsPresent()){
                    pause(1000);
                    fillLoginForm(email, password);
                    submitYalla();
                    pause(1000);
                    clickRentNow();
                }
                    break;
            } else {
                wd.navigate().back();
                System.out.println(i);
                size--;
            }
        }

    }

    private boolean loginIsPresent() {
        return isElementPresent(By.cssSelector("form:first-child"));
    }

    public void clickRentNow() {
        click(By.xpath("//button[text()='Rent now!! ']"));
    }

    public void fillOrderForm(User user) {
        pause(1000);
        typeTextBox(By.id("firstName"), user.getName());
        typeTextBox(By.id("secondName"), user.getLastName());
        typeTextBox(By.id("email"), user.getEmail());
        typeTextBox(By.id("phone"), user.getPhoneNumber());

    }

    public void submitOrderForm() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isOrderSuccess() {
        return isElementPresent(By.className("message"));
    }

    public void closeOrderSuccess() {
        click(By.className("positive-button"));
    }
}
