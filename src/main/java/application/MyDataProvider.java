package application;

import org.testng.annotations.DataProvider;

import java.util.*;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validDataLoginClass(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"slavka.lenetz@gmail.com","Ilcarro123"});
        list.add(new Object[]{"slavka.lenetz@gmail.com","Ilcarro123"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> inValidDataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"slavka.lenetz@gmail.com","Ilcarro123"});
        list.add(new Object[]{"slavka.lenetz@gmail.com","Ilcarro123"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});

        return list.iterator();
    }
}
