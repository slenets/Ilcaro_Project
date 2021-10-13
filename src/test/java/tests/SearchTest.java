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

    }
}
