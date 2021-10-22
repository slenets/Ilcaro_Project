package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RentHelper extends HelperBase{

    public RentHelper(WebDriver wd) {
        super(wd);
    }


    public void selectCar() {
        List<WebElement> elementList = wd.findElements(By.className(".car-container"));

        click(By.xpath("//a[contains(@href, '990')]"));
    }

    public void clickRentNow() {
        click(By.xpath("//button[text()='Rent now!! ']"));
    }

    public void fillOrderForm(User user) {
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
