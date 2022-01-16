package application.dataprovider;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    @DataProvider()
    public Iterator<Object[]> dataLoginCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/data/3positiveLoginData.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] strs = line.split(",");
            list.add(new Object[]{new User().withEmail(strs[0]).withPassword(strs[1])});
            line= reader.readLine();
        }
        return list.iterator();
    }
}
