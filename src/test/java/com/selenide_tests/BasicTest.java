package com.selenide_tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by babych on 21.11.2015.
 */
public class BasicTest {

@BeforeTest
public void Before(){
    open("http://google.com");
}



}
