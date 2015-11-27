package com.selenide_pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by babych on 23.11.2015.
 */
public class DriverLogInPage {

    @FindBy(how = How.ID, using = "user_forms_login_form_email")
    public SelenideElement emailField;

    @FindBy(how = How.ID, using = "user_forms_login_form_password")
    public SelenideElement passwordField;

    @FindBy(how = How.CSS, using = ".next-btn.btn.btn-success.pull-right")
    public SelenideElement loginBtn;

    @FindBy(how = How.CSS, using = ".ibox-title>h1")
    public SelenideElement DriverloginLable;

    public DotApplications loginClick(String email, String pass){
        emailField.setValue(email);
        passwordField.setValue(pass);
        loginBtn.click();
        return page(DotApplications.class);
    }

    public void isLoginLbl(){
        DriverloginLable.shouldHave(text("User log in"));
    }


}
