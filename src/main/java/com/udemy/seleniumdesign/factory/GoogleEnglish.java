package com.udemy.seleniumdesign.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    @FindBy(css = "div.jtfYYd")
    private List<WebElement> results;

    @FindBy(linkText = "English")
    private WebElement language;

    public GoogleEnglish(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
        this.language.click();
    }

    @Override
    public void search(String keyword) {
        for(char ch : keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.wait.until((d) -> this.searchButton.isDisplayed());
        this.searchButton.click();
    }

    @Override
    public int getResultsCount() {
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }
}
