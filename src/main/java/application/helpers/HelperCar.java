package application.helpers;

import application.helpers.HelperBase;
import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {
        super(wd);
    }


    public void initAddingNewCar() {
        click(By.xpath("//a[@href='/let-car-work']"));
    }

    public void fillAddCarForm(Car car){
        typeLocation(car.getAddress());
        typeTextBox(By.id("make"), car.getMake());
        typeTextBox(By.id("model"), car.getModel());
        typeTextBox(By.id("year"), car.getYear());
        typeTextBox(By.id("engine"), car.getEngine());
        //--------------------------------------------
        select(By.id("fuel"), car.getFuel());
        select(By.id("gear"), car.getGear());
        select(By.id("wheelsDrive"), car.getWD());
        //--------------------------------------------
        typeTextBox(By.id("doors"), car.getDoors());
        typeTextBox(By.id("seats"), car.getSeats());
        typeTextBox(By.id("class"), car.getCarClass());
        typeTextBox(By.id("fuelConsumption"), car.getFuelConsumption());
        typeTextBox(By.id("serialNumber"), car.getCarRegNumber());
        typeTextBox(By.id("price"), car.getPrice());
        typeTextBox(By.id("distance"), car.getDistanceIncluded());
        typeTextBox(By.className("feature-input"), car.getTypeFeature());
        typeTextBox(By.id("about"), car.getAbout());
    }

    private void select(By locator, String option) {
        //new Select(wd.findElement(locator)).selectByIndex(1);
        // new Select(wd.findElement(locator)).selectByValue("Petrol");
        new Select(wd.findElement(locator)).selectByVisibleText(option);
    }

    private void typeLocation(String address) {
        Math.random();
        typeTextBox(By.id("pickUpPlace"), address);
        pause(500);
        click(By.cssSelector("div.pac-item"));
        pause(500);

    }

    public void attachPhoto() {
        wd.findElement(By.id("photos"))
                .sendKeys("C:\\Qa29\\Ilcaro_Project\\Subaru.jpg");

    }

    public void submitForm() {
        WebElement el = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Submit']")));
        el.click();
        //click(By.xpath("//button[.='Submit']"));
    }

    public boolean isCarAdded() {
       return wd.findElement(By.xpath("//h1[text()='Car added']")).isDisplayed();
    }

    public void showAddedCar() {
        click(By.xpath("//button[text()='Show car']"));
    }
}
