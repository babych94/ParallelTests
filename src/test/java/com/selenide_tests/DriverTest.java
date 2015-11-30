package com.selenide_tests;

import com.codeborne.selenide.Condition;
import com.selenide_pages.DotApplications;
import com.selenide_pages.DriverLogInPage;
import com.selenide_pages.DriverreachPage;
import com.selenide_pages.VeiwPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by babych on 23.11.2015.
 */
public class DriverTest extends BasicTest{

    @Test(priority = 1)
    public void OpenDrivereach(){

        DriverLogInPage driverLogInPage = open("https://staging.driverreachapp.com/users/login", DriverLogInPage.class);
        driverLogInPage.isLoginLbl();
        DotApplications dotApplications = driverLogInPage.loginClick("yoshka151@gmail.com", "!123456");      //Full table
     //   DotApplications dotApplications = driverLogInPage.loginClick("test@auto.com", "!123456");                //Empty table
        dotApplications.isRowsPresent();
        driverLogInPage.isLoginLbl();

    }




}
