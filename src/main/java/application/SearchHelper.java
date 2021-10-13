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
        selectFutureDate(dateFrom, dateTo);
    }

    public void fillSearchFormFuture(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectFutureDate(dateFrom, dateTo);
    }

    private void selectDate(String dateFrom, String dateTo) {
        String[] dateF = dateFrom.split("/");
        String[] dateT = dateTo.split("/");
        click(By.id("dates"));

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
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public void clickYallaButton() {
    }

    public boolean islistOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }
}
