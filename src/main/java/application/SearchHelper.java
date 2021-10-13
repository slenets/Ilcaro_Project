package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class SearchHelper extends HelperBase {


    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void findCarForm() {
        typeTextBox(By.id("city"), "Tel Aviv Israel");
    }

    public void fillSearchForm(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectDate(dateFrom, dateTo);
    }

    private void selectDate(String dateFrom, String dateTo) {
        String[] dataF = dateFrom.split("/");
        String[] dataT = dateTo.split("/");
        click(By.id("dates"));

        String locatorFrom = String.format("//div[text()=' %s ']",dataF[1]);
        String locatorTo = String.format("//div[text()=' %s ']",dataT[1]);

        click(By.xpath(locatorFrom));
        click(By.xpath(locatorTo));

    }

    public void selectFutureDate(String dateFrom, String dateTo){
        // click input calendar
        // which month is now?
        int month = LocalDate.now().getMonthValue();
        //dateF[0]-month = 

    }

    private void fillInputCity(String city) {
        typeTextBox(By.id("city"), city);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public void clickYallaButton() {
    }

    public boolean islistOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }
}
