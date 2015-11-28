package com.selenide_tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.selenide_pages.DotApplications;
import com.selenide_pages.DriverLogInPage;
import com.selenide_pages.SettingsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static java.sql.DriverManager.getDriver;

/**
 * Created by babych on 24.11.2015.
 */
public class DriverCase2 extends BasicTest{



    @Test
    public void Case2(){
        DriverLogInPage driverLogInPage = open("https://staging.driverreachapp.com/users/login", DriverLogInPage.class);
        driverLogInPage.isLoginLbl();
        DotApplications dotApplications = driverLogInPage.loginClick("yoshka151@gmail.com", "yoshka151@gmail.com");
        SettingsPage settingsPage = dotApplications.openSettings();
        settingsPage.settingsLable.shouldHave(Condition.text("Settings"));
        settingsPage.billingTabClick();
        settingsPage.cardOperations("Card name", "4242424242424242", "123", "4000000000000119");  //4000000000000119   4242424242424242
        settingsPage.errEnable();
       driverLogInPage = dotApplications.Logout();
       driverLogInPage.isLoginLbl();

    }

}
