package application.helpers;

import application.helpers.HelperBase;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//div[@class='header']/a[6]"));
        //              //a[text()=' Log in ']
    }

    public void fillLoginForm(User user) {
        typeTextBox(By.xpath("//input[@formcontrolname='email']"), user.getEmail());
        typeTextBox(By.xpath("//input[@formcontrolname='password']"), user.getPassword());
        pause(1000);
    }

    public void clickEmailField(){
        click(By.xpath("//input[@formcontrolname='email']"));
    }

    public void clickPasswordField(){
        click(By.xpath("//input[@formcontrolname='password']"));
    }



    public void submitLoginForm() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isLogged() {
        String text = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        return text.equals("Logged in success");
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        typeTextBox(By.id("name"), name);
        typeTextBox(By.id("lastName"), lastName);
        typeTextBox(By.id("email"), email);
        typeTextBox(By.id("password"), password);
    }

    public void fillRegistrationForm(User user) {
        typeTextBox(By.id("name"), user.getName());
        typeTextBox(By.id("lastName"), user.getLastName());
        typeTextBox(By.id("email"), user.getEmail());
        typeTextBox(By.id("password"), user.getPassword());
    }

    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[.='Ok']"))) {
            click(By.xpath("//button[.='Ok']"));
        }
    }


    public void fillCheckBox() {
        //click(By.xpath("//label[@for='terms-of-use']"));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
        //js.executeScript("document.querySelector('#terms-of-use').checked=true;");
    }

    public void submitRegistrationForm() {
        click(By.xpath("//button[@type='submit']"));

    }

    public boolean isRegistrationSuccess() {
        WebElement dialog = wd.findElement(By.cssSelector(".dialog-container h2"));
        String message = dialog.getText();
        return message.equals("You are logged in success");
    }

    public boolean isEmailErrorDisplayed() {
        // click(By.id("email"));
        return isElementPresent(By.xpath("//div[text()='Wrong email format']"));

    }

    public boolean isYallaButtonActive() {
        return wd.findElement(By.xpath("//button[@type='submit']")).isSelected();
        //return isElementPresent(By.xpath("//button[@disabled]"));
    }

    public boolean isEmptyEmailWarning(){
        return isElementPresent(By.xpath("//div[text()=' Email is required ']"));
    }

    public boolean isEmptyPasswordWarning(){
        return isElementPresent(By.xpath("//div[text()=' Password is required ']"));
    }

}
