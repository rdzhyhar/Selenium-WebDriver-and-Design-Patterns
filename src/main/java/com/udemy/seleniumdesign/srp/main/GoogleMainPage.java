package com.udemy.seleniumdesign.srp.main;

import com.udemy.seleniumdesign.srp.commom.SearchSuggestions;
import com.udemy.seleniumdesign.srp.commom.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestions searchSuggestions;

    public GoogleMainPage(final WebDriver driver){
        this.driver=driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestions = PageFactory.initElements(driver, SearchSuggestions.class);
    }

    public void goTo(){
        this.driver.get("https://www.google.com.ua/");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestions getSearchSuggestions() {
        return searchSuggestions;
    }
}
