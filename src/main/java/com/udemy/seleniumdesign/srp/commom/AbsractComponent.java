package com.udemy.seleniumdesign.srp.commom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbsractComponent {

    protected WebDriverWait wait;

    public AbsractComponent(final WebDriver driver){
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }


    public abstract boolean isDisplayed();


}
