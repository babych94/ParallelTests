package com.selenide_tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.impl.Navigator;
import com.selenide_pages.DotApplications;
import com.selenide_pages.DriverLogInPage;
import com.selenide_pages.SettingsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static java.sql.DriverManager.getDriver;

/**
 * Created by babych on 24.11.2015.
 */
public class DriverCase2 extends BasicTest{

@Parameters({"Login", "Pass"})

    @Test(priority = 2)
    public void Case2(String Login, String Pass){
        DriverLogInPage driverLogInPage = open("https://staging.driverreachapp.com/users/login", DriverLogInPage.class);
        driverLogInPage.isLoginLbl();
        DotApplications dotApplications = driverLogInPage.loginClick(Login, Pass);
        SettingsPage settingsPage = dotApplications.openSettings();
        settingsPage.isSettingsLBL();
        settingsPage.billingTabClick();
        settingsPage.MakeCardOperations();
        driverLogInPage.isLoginLbl();

    }

}
