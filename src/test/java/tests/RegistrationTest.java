package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }

    @Test(groups = {"web"})
    public void registrationPositiveTest() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Andy", "Candy", "andycandy" + i + "@gmail.com", "AndyCandy"+i+"123");
        app.userHelper().fillCheckBox();
        app.userHelper().submitRegistrationForm();
        Assert.assertTrue(app.userHelper().isRegistrationSuccess());

    }


    //Model- With fluence style
    @Test
    public void registrationPositiveTestModel() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Lis")
                .withLastName("Snow")
                .withEmail("snow" +i+ "@gmail.com")
                .withPassword("Lis"+i+"ndy123");

        logger.info("TestData: name:" + user.getName() + " LastName: " + user.getLastName() + "Email: " + user.getEmail()
        + " Password: " + user.getPassword());

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm(user);
        app.userHelper().fillCheckBox();
        app.userHelper().submitRegistrationForm();
        Assert.assertTrue(app.userHelper().isRegistrationSuccess());

    }



    @Test
    public void registrationNegativeTest() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Andy", "Candy", "andycandy" + i + "gmail.com", "AndyCa"+i+"ndy123");
        app.userHelper().fillCheckBox();
        app.userHelper().fillCheckBox();
        app.userHelper().submitRegistrationForm();

        Assert.assertTrue(app.userHelper().isEmailErrorDisplayed());
        Assert.assertFalse(app.userHelper().isYallaButtonActive());

    }

//    @Test
//    public void registrationNegativeTest(){
//
//    }


    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.userHelper().clickOkButton();

    }


//    @Test
//    public void registrationPositive(){
//        openRegistrationForm();
//        fillRegistrationForm("Andy", "Candy", "andycandy@gmail.com", "AndyCandy123");
//        fillCheckBox();
//        submitRegistrationForm();
//        Assert.assertTrue(isRegistered(".dialog-container h2"));
//    }
//
//    @Test
//    public void registrationNegative(){
//        openRegistrationForm();
//        fillRegistrationForm("Andy", "Candy", "andycandy@gmail.com", "AndyCandy123");
//        fillCheckBox();
//        submitRegistrationForm();
//        Assert.assertFalse(isRegistered(".dialog-container h2"));
//    }
//
//    @AfterMethod
//    public void postCondition(){
//        if(isDeleteAccountPresent()) {
//            deleteAccount();
//        }
//    }
}
