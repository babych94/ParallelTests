package com.selenide_tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

/**
 * Created by babych on 21.11.2015.
 */
public class BasicTest {

   public WebDriver driver;

    public DesiredCapabilities capabilities;

@BeforeTest
@Parameters({"browser"})
public void Before(String browser) throws MalformedURLException {

    String urlAddress = "http://192.168.2.124:4444/wd/hub";

    if(browser.equalsIgnoreCase("chrome")){

        System.out.println("Chrome browser");
        capabilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new java.net.URL(urlAddress), capabilities);
        driver.manage().window().maximize();
    }

    if(browser.equalsIgnoreCase("internet explorer")){

        System.out.println("Internet explorer browser");
        capabilities = DesiredCapabilities.internetExplorer();
        driver = new RemoteWebDriver(new java.net.URL(urlAddress), capabilities);
        driver.manage().window().maximize();
    }
    WebDriverRunner.setWebDriver(driver);

}


@AfterTest
    public void quitTest(){

    WebDriverRunner.closeWebDriver();
    driver.quit();
}

}
