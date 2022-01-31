package com.udemy.seleniumdesign.srp.commom;

import com.udemy.seleniumdesign.srp.commom.AbsractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestions extends AbsractComponent {

    @FindBy(css = "li.sbct")
    private List<WebElement> suggestions;

    public SearchSuggestions(final WebDriver driver){
        super(driver);
    }

    public void clickSuggestionByIndex(int index){
        this.suggestions.get(index - 1).click();
    }


    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.suggestions.size() > 5);
    }
}
