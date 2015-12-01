package com.selenide_tests;

import com.selenide_pages.DotApplications;
import com.selenide_pages.DriverLogInPage;
import com.selenide_pages.SettingsPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by babych on 24.11.2015.
 */
public class DriverCase2 extends BasicTest{

@Parameters({"Login", "Pass"})

    @Test(priority = 2)
    public void Case2(String Login, String Pass){
        DriverLogInPage driverLogInPage = open("https://staging.driverreachapp.com/users/login", DriverLogInPage.class);
     //   driverLogInPage.isLoginLbl();
        DotApplications dotApplications = driverLogInPage.loginClick(Login, Pass);
        SettingsPage settingsPage = dotApplications.openSettings();
        settingsPage.isSettingsLBL();
        settingsPage.billingTabClick();
        settingsPage.MakeCardOperations();
        driverLogInPage.isLoginLbl();

    }

}
