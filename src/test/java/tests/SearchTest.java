package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    //10/20/2021 - 10/22/2021
    //09/20/2021 - 09/22/2021
    @Test
    public void searchTestByType(){

    }

    @Test
    public void searchTestByTypeNegative(){

    }

    @Test
    public void searchDateBySelectCurrentMonth(){
        //date-picker
        app.getSearchHelper().fillSearchForm("Haifa", "10/25/2021", "10/30/2021");
        app.userHelper().submitLoginForm();
        app.userHelper().pause(500);
        Assert.assertTrue(app.getSearchHelper().islistOfCarsAppeared());

        logger.info("Chosen date in current month of the year");
    }

    @Test
    public void searchDateBySelectAnyMonth(){
        //date-picker
        app.getSearchHelper().fillSearchFormFuture("Haifa", "10/22/2021", "10/29/2021");
        app.userHelper().submitLoginForm();
        app.userHelper().pause(500);
        Assert.assertTrue(app.getSearchHelper().islistOfCarsAppeared());

        logger.info("Chosen date in future: from current day and until one year forward only");
    }
}
