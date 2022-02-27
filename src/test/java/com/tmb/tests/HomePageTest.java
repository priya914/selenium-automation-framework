package com.tmb.tests;

import com.tmb.driver.DriverManager;
import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public final class HomePageTest extends  BaseTest{

    private HomePageTest() {

    }

    @Test
    public void test3() {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing Mini Bytes", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

                 assertThat(title)
                .as("Title is null").isNotNull()
                .as("does not contain expected text").containsIgnoringCase("Google search")
                .hasSizeBetween(1, 50);
//        Assert.assertTrue(Objects.nonNull(title));
////        Assert.assertTrue(title.toLowerCase().contains("Google search"));
//        Assert.assertTrue(title.length()>15);
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3[contains(text(), 'Testing Mini Bytes -')]"));
        Assert.assertEquals(elements.size(), 1);

                 assertThat(elements)
                .hasSize(1)
                .extracting(WebElement::getText)
                .contains("Testing Mini Bytes - YouTube");

//        boolean isElementPresent = false;
//
//        for(WebElement element : elements) {
//            System.out.println(element);
//            if(element.getText().equalsIgnoreCase("Testing Mini Bytes - YouTube")) {
//                isElementPresent = true;
//            }
//        }
//        Assert.assertTrue(isElementPresent, "Not found");
    }


}
