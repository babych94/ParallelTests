package com.selenide_pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by babych on 24.11.2015.
 */
public class VeiwPage {

    @FindBy(how = How.TAG_NAME, using = "h2")
            public SelenideElement nameField;

    @FindBy(how = How.CSS, using = ".dropdown-toggle.btn.btn-link")
    public SelenideElement accountButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[1]/nav/div/div/ul/li[3]/a")
    public SelenideElement logoutButton;

    public DriverLogInPage Logout(){
        accountButton.click();
        logoutButton.click();
        return page(DriverLogInPage.class);
    }

}
