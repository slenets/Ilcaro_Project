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
                .withPhoneNumber("+788822" + i + "45");

        if (!app.userHelper().isLogOutPresent()) {
            app.userHelper().openLoginForm();
        }
        app.userHelper().fillLoginForm("slavka.lenetz@gmail.com", "Ilcarro123");
        app.userHelper().submitYalla();
        app.userHelper().clickOkButton();
        app.rentHelper().pause(1000);

        app.getSearchHelper().fillSearchFormFuture("Tel Aviv", "11/1/2021", "11/12/2021");
        app.getSearchHelper().submitYalla();
        app.rentHelper().open50items();
        app.rentHelper().selectCarAndRent();
        app.rentHelper().fillOrderForm(user);
        app.rentHelper().submitOrderForm();

        Assert.assertTrue(app.rentHelper().isOrderSuccess());

    }

    @Test
    public void rentCarBeforeLogin(){
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Lis")
                .withLastName("Snow")
                .withEmail("snow" + i + "@gmail.com")
                .withPassword("Lis" + i + "ndy123")
                .withPhoneNumber("+788899" + i + "45");

        app.getSearchHelper().fillSearchFormFuture("Tel Aviv", "11/1/2021", "11/12/2021");
        app.getSearchHelper().submitYalla();
        app.rentHelper().open50items();
        app.rentHelper().selectCarAndRent("slavka.lenetz@gmail.com", "Ilcarro123");
        app.getSearchHelper().pause(1000);
        app.rentHelper().fillOrderForm(user);
        app.rentHelper().submitOrderForm();
        app.rentHelper().pause(1000);
        Assert.assertTrue(app.rentHelper().isOrderSuccess());
    }

    @AfterMethod
    public void postCondition(){
        app.rentHelper().closeOrderSuccess();
        app.rentHelper().pause(1000);
        app.userHelper().logout();
        app.getSearchHelper().clickSearchHeader();
    }
}
