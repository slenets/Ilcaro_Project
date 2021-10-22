package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class RentTest extends TestBase {

    @Test
    public void rentCarWithLogin() {
        // Pick up period - 11/1/2021-11/12/2021
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Lis")
                .withLastName("Snow")
                .withEmail("snow" + i + "@gmail.com")
                .withPassword("Lis" + i + "ndy123")
                .withPhoneNumber("+7888" + i + "45");

        if (!app.userHelper().isLogOutPresent()) {
            app.userHelper().openLoginForm();
        }
        app.userHelper().fillLoginForm("slavka.lenetz@gmail.com", "Ilcarro123");
        app.userHelper().submitYalla();
        app.userHelper().clickOkButton();

        app.getSearchHelper().fillSearchFormFuture("Rehovot", "11/1/2021", "11/12/2021");
        app.getSearchHelper().submitYalla();
        app.rentHelper().selectCar();
        app.rentHelper().clickRentNow();
        app.rentHelper().fillOrderForm(user);
        app.rentHelper().submitOrderForm();

        Assert.assertTrue(app.rentHelper().isOrderSuccess());

    }

    @AfterMethod
    public void postCondition(){
        app.rentHelper().closeOrderSuccess();
    }
}
