package application.helpers;

import application.helpers.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class SearchHelper extends HelperBase {


    public SearchHelper(WebDriver wd) {
        super(wd);
    }


    public void fillSearchFormCurrent(String city, String dateFrom, String dateTo) {
        pause(1000);
        fillInputCity(city);
        selectDateCurrentMonth(dateFrom, dateTo);
    }

    public void fillSearchFormFuture(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectFutureDate(dateFrom, dateTo);
    }

    private void selectDateCurrentMonth(String dateFrom, String dateTo) {
        String[] dateF = dateFrom.split("/");
        String[] dateT = dateTo.split("/");

        if(isElementPresent(By.id("dates"))) {
            click(By.id("dates"));
        }else{
            click(By.cssSelector("[formcontrolname='dates']"));
        }

        String locatorFrom = String.format("//div[text()=' %s ']", dateF[1]);
        String locatorTo = String.format("//div[text()=' %s ']", dateT[1]);

        click(By.xpath(locatorFrom));
        click(By.xpath(locatorTo));

    }

    //1/20/2022 - 5/22/2022
    public void selectFutureDate(String dateFrom, String dateTo) {
        String[] dateF = dateFrom.split("/");
        String[] dateT = dateTo.split("/");
        String locatorFrom = String.format("//div[text()=' %s ']", dateF[1]);
        String locatorTo = String.format("//div[text()=' %s ']", dateT[1]);

        // click input calendar
        click(By.id("dates"));
        // which month is now?
        int month = LocalDate.now().getMonthValue();

        int monthFrom = Integer.parseInt(dateF[0]) - month;
        int monthTo = Integer.parseInt(dateT[0]) - Integer.parseInt(dateF[0]);

        //11/20/2021 - 5/22/2022
        if (Integer.parseInt(dateF[2]) == 2021 && Integer.parseInt(dateT[2]) == 2022) {
            monthFrom = Integer.parseInt(dateF[0]) - month; // 11 - 10 = 1
            monthTo = Integer.parseInt(dateT[0]) + 12 - Integer.parseInt(dateF[0]); // 5 + 12 - 11 = 6
        }

        //1/20/2022 - 5/22/2022
        if(Integer.parseInt(dateF[2]) == 2022 && Integer.parseInt(dateT[2]) == 2022){
            monthFrom = Integer.parseInt(dateF[0]) + 12 - month; // 13 - 10 = 3
            monthTo = (Integer.parseInt(dateT[0]) + 12) - (Integer.parseInt(dateF[0]) + 12); // (5 + 12) - (1 + 12) = 4
        }

        if (monthFrom > 0) {
            for (int i = 0; i < monthFrom; i++) {
                click(By.xpath("//button[@aria-label='Next month']"));
            }
        }

        click(By.xpath(locatorFrom));

        if (monthTo > 0) {
            for (int i = 0; i < monthTo; i++) {
                click(By.xpath("//button[@aria-label='Next month']"));
            }
        }

        click(By.xpath(locatorTo));

    }

    private void fillInputCity(String city) {
        typeTextBox(By.id("city"), city);
        //click(By.cssSelector("div.pac-item"));

        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector(".pac-item"))).click().perform();
    }

    public boolean islistOfCarsAppeared() {
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-results")));
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public boolean isSearchFormPresent() {
        return wd.findElements(By.xpath("//h1[text()='Find your car now!']")).size() > 0;
    }

    public void clickSearchHeader() {
        click(By.xpath("//a[text()=' Search '] "));
    }

    public void typeDate(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        typeTextBox(By.cssSelector("[formcontrolname='dates']"), dateFrom +" - "+ dateTo);
        click(By.cssSelector(".cdk-overlay-container"));
    }

    public boolean isErrorPresent() {
        return isElementPresent(By.className("ng-star-inserted"));
    }
}
