package com.selenide_pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by babych on 23.11.2015.
 */
public class DriverreachPage {

    @FindBy(how = How.CSS, using = ".ibox-title>p>a")
    public SelenideElement loginLink;

    public DriverLogInPage logInclick(){
        $(By.cssSelector(".ibox-title>p>a")).click();
        return page(DriverLogInPage.class);
    }

    public void isLogPresent() {
        $(By.cssSelector(".ibox-title>p>a"));
    }

}
