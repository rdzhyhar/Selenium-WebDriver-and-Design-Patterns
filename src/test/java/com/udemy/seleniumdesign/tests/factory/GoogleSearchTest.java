package com.udemy.seleniumdesign.tests.factory;

import com.udemy.seleniumdesign.factory.GoogleFactory;
import com.udemy.seleniumdesign.factory.GooglePage;
import com.udemy.seleniumdesign.tests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword){
        this.googlePage = GoogleFactory.get(language,driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultsCount();
        System.out.println("Result count : " + resultCount);

    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"ENG","selenium"},
                {"FR","design patterns"},
                {"SA","docker"},
                {"ES","selenium"}
        };
    }

}
