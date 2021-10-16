package tests;

import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase{

@BeforeMethod
    public void precondition(){
    //login
    if(app.userHelper().isElementPresent(By.xpath("//a[text()=' Log in ']"))) {
        User user = new User().withEmail("slavka.lenetz@gmail.com").withPassword("Ilcarro123");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitRegistrationForm();
    }
}

@Test
public void addNewCarSuccess(){
    //add car

    int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

    Car car = new Car()
            .withAddress("Tel Aviv, Israel")
            .withMake("BMW")
            .withModel("M5"+i)
            .withYear("2020")
            .withEngine("2.3")
            .withFuel("Petrol")
            .withGear("MT")
            .withwD("AWD")
            .withDoors("5")
            .withSeats("4")
            .withCarClass("C")
            .withFuelConsumption("6.5")
            .withCarRegNumber("100-"+i+"-33-444")
            .withPrice("65")
            .withDistanceIncluded("500")
            .withTypeFeature("feature")
            .withAbout("Very good car");

    app.carHelper().initAddingNewCar();
    app.carHelper().fillAddCarForm(car);
    app.carHelper().attachPhoto();
    app.carHelper().submitForm();
    Assert.assertTrue(app.carHelper().isCarAdded());
    app.carHelper().showAddedCar();

}

}
