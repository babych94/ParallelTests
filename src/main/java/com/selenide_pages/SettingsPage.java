package com.selenide_pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


/**
 * Created by babych on 24.11.2015.
 */
public class SettingsPage {

    @FindBy(how = How.CSS, using = ".active>strong")
    public SelenideElement settingsLable;

    @FindBy(how = How.CSS, using = ".panel-body>h3")
    public SelenideElement noCardLable;

    @FindBy(how = How.CLASS_NAME, using = "modal-title")
    public SelenideElement modalWindow;

    @FindBy(how = How.XPATH, using = ".//*[@id='credit-cards-table']/tbody/tr/td[5]/a")
    public SelenideElement removeButton;

    @FindBy(how = How.XPATH, using = ".//div[3]/div/div/div/div/div/div/div/a")
    public SelenideElement addCardButton;

    @FindBy(how = How.ID, using = "credit_card_name")
    public SelenideElement nameCardField;

    @FindBy(how = How.ID, using = "number")
    public SelenideElement numberCardField;

    @FindBy(how = How.XPATH, using = ".//*[@id='card_year_chosen']/a")
    public SelenideElement yearButton;

    @FindBy(how = How.XPATH, using = "//*[@id='card_year_chosen']/div/div/input")
    public SelenideElement inputYearfield;

    @FindBy(how = How.ID, using = "cvv")
    public SelenideElement cvvField;

    @FindBy(how = How.CSS, using = ".btn.btn-success.pull-right")
    public SelenideElement saveButton;

    @FindBy(how = How.ID, using = "dr-modal")
    public SelenideElement modalElementWindow;

    @FindBy(how = How.CSS, using = ".dropdown-toggle.btn.btn-link")
    public SelenideElement accountButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[1]/nav/div/div/ul/li[3]/a")
    public SelenideElement logoutButton;

    @FindBy(how = How.ID, using = "credit-cards-table")
    public SelenideElement creditTable;

    @FindBy(how = How.XPATH, using = ".//*[@id='credit-cards-table']/thead/tr/th[2]")
    public SelenideElement ErrRow;

    public void billingTabClick(){
        $(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div/ul/li[4]/a")).click();
    }

    public boolean errEnable(){
        boolean error = false;                    //   "//*[@id="credit-cards-table"]/thead/tr/th[2]"
            if (ErrRow.has(text("Errors"))) {
                error = true;
                System.out.println("Card is broken");
        }

        return error;
    }

    public void Waiter(){
        addCardButton.waitUntil(appear, 3000);
    }

    public void cardOperations(String nameCard, String numberCard, String cvv, String changeCard){
        Waiter();
        if(removeButton.is(visible)) {
            addCardButton.click();
            modalWindow.shouldHave(Condition.text("Checkout"));
            nameCardField.setValue(nameCard);
            numberCardField.setValue(changeCard);
            yearButton.click();
            inputYearfield.setValue("2020").pressEnter();
            cvvField.setValue(cvv);
            saveButton.click();

            modalElementWindow.waitUntil(Condition.disappear, 10000);
            System.out.println("Card was changed");
       // removeButton.should(Condition.enabled).click();
       // confirm("Are you sure you want to remove credit card 'Card name' ?");

        } else if(noCardLable.is(visible)){

            addCardButton.click();
            modalWindow.shouldHave(Condition.text("Checkout"));
            nameCardField.setValue(nameCard);
            numberCardField.setValue(numberCard);
            yearButton.click();
            inputYearfield.setValue("2017").pressEnter();
            cvvField.setValue(cvv);
            saveButton.click();
            modalElementWindow.waitUntil(Condition.disappear, 10000);
            System.out.println("New card was added successfully");

        }

    }

    public void MakeCardOperations(){
        if (errEnable()==true){
            Logout();
        } else if (errEnable()==false){
            cardOperations("Card name", "4242424242424242", "123", "4000000000000119");
            Logout();
        }
    }

    public void isSettingsLBL(){
        settingsLable.shouldHave(Condition.text("Settings"));
    }


    public DriverLogInPage Logout(){
        accountButton.click();
        logoutButton.click();
        return page(DriverLogInPage.class);
    }


}
