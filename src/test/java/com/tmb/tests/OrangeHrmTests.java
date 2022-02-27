package com.tmb.tests;

import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.utils.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class OrangeHrmTests extends BaseTest{

    private OrangeHrmTests() {}

//    @Test(dataProvider =  "LoginTestData")
//    public void loginLogoutTest(String username, String password) {
//        String title = new OrangeHRMLoginPage()
//                .enterUsername(username).enterPassword(password).clickLogin()
//                .clickWelcome().clickLogout().getTitle();
//        Assertions.assertThat(title)
//                .isEqualTo("OrangeHRM");
//    }

    @Test
    public void loginLogoutTest(Map<String, String> data) {
        String title = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickWelcome().clickLogout().getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    public void newTest (Map<String, String> data) {
        String title = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickWelcome().clickLogout().getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }


//    @DataProvider(name = "LoginTestData", parallel = true)
//    public Object[][] getData() {
//
//        return new Object[][] {
//                {"Admin", "admin123"},
//                {"Admin1", "admin123"}
//        };
//    }
}
