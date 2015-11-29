package com.selenide_tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.codeborne.selenide.WebDriverProvider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by babych on 21.11.2015.
 */
public class BasicTest {
 /*
   public WebDriver driver;

    public DesiredCapabilities capabilities;

@BeforeTest
@Parameters({"browser"})
public void Before(String browser) throws MalformedURLException {

    String urlAddress = "http://10.0.11.44:4444/wd/hub";

    if(browser.equalsIgnoreCase("chrome")){

        System.out.println("Chrome browser");
        capabilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL(urlAddress), capabilities);
        driver.manage().window().maximize();
    }

    if(browser.equalsIgnoreCase("internet explorer")){

        System.out.println("internet explorer browser");
        capabilities = DesiredCapabilities.internetExplorer();
        driver = new RemoteWebDriver(new URL(urlAddress), capabilities);
        driver.manage().window().maximize();
    }
    WebDriverRunner.setWebDriver(driver);

}


@AfterTest
    public void quitTest(){

    WebDriverRunner.closeWebDriver();
    driver.quit();
}
  */
}
