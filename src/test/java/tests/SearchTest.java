package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    //10/20/2021 - 10/22/2021
    //09/20/2021 - 09/22/2021
    @BeforeMethod
    public void precondition(){
        if(!app.getSearchHelper().isSearchFormPresent()){
            app.getSearchHelper().clickSearchHeader();
        }
    }

    @Test()
    public void searchTestByType(){
        app.getSearchHelper().typeDate("Haifa", "2/2/2022", "5/2/2022");
        app.getSearchHelper().submitYalla();
        Assert.assertTrue(app.getSearchHelper().islistOfCarsAppeared());
    }

    @Test
    public void searchTestByTypeNegative(){
        app.getSearchHelper().typeDate("Haifa", "2/2/2022", "5/2/2021");
        Assert.assertTrue(app.getSearchHelper().isErrorPresent());
        Assert.assertFalse(app.getSearchHelper().isYallaButtonActive());
    }

    @Test
    public void searchDateBySelectCurrentMonth(){
        //date-picker
        app.getSearchHelper().fillSearchFormCurrent("Haifa", "11/15/2021", "11/17/2021");
        app.userHelper().submitYalla();
        app.userHelper().pause(1000);
        Assert.assertTrue(app.getSearchHelper().islistOfCarsAppeared());

        logger.info("Chosen date in current month of the year");
    }

    @Test
    public void searchDateBySelectAnyMonth(){
        //date-picker
        app.getSearchHelper().fillSearchFormFuture("Haifa", "11/18/2021", "12/1/2021");
        app.userHelper().submitYalla();
        app.userHelper().pause(500);
        Assert.assertTrue(app.getSearchHelper().islistOfCarsAppeared());

        logger.info("Chosen date in future: from current day and until one year forward only");
    }

//    @AfterMethod
//    public void postCondition(){
//        app.getSearchHelper().clickSearchHeader();
//    }
}
