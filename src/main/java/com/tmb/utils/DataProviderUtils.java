package com.tmb.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils  {

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[] getData(Method m) {

        String testName = m.getName();


//        List<Map<String, String>> list = ExcelUtils.getTestDetails("DATA");

        if(list.isEmpty()) {

            list = ExcelUtils.getTestDetails("DATA");

        }

        List<Map<String, String>> smallIterationList = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).get("testname").equalsIgnoreCase(testName) &&
                list.get(i).get("execute").equalsIgnoreCase("yes")) {
                    smallIterationList.add(list.get(i));

            }

        }



        return smallIterationList.toArray();

    }
}
