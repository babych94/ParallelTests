package com.selenide_pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.omg.PortableInterceptor.HOLDING;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

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

    @FindBy(how = How.XPATH, using = ".//*[@id='credit-cards-table']/tbody/tr/td[2]")
    public SelenideElement errorText;

    @FindBy(how = How.CSS, using = ".dropdown-toggle.btn.btn-link")
    public SelenideElement accountButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[1]/nav/div/div/ul/li[3]/a")
    public SelenideElement logoutButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='credit-cards-table']/thead/tr/th[2]")
    public SelenideElement errorRowTable;

    public void billingTabClick(){
        $(By.xpath(".//*[@id='page-wrapper']/div[3]/div/div/div/ul/li[4]/a")).click();
    }

    public void cardOperations(String nameCard, String numberCard, String cvv, String changeCard){

        String nocardText = "You have no credit cards.";
       SelenideElement notExist = noCardLable.shouldNot(Condition.exist);

        if(noCardLable.isDisplayed()) {
            addCardButton.click();
            modalWindow.shouldHave(Condition.text("Checkout"));
            nameCardField.setValue(nameCard);
            numberCardField.setValue(numberCard);
            yearButton.click();
            inputYearfield.setValue("2017").pressEnter();
            cvvField.setValue(cvv);


            saveButton.click();
            modalElementWindow.waitUntil(Condition.disappear, 10000);


       // removeButton.should(Condition.enabled).click();

       // confirm("Are you sure you want to remove credit card 'Card name' ?");

            if(errorRowTable.getText()=="Errors"){
                System.out.println("Test filed");
            }

           // removeButton.should(Condition.be(Condition.visible));

        } else if (removeButton.isDisplayed()){
            addCardButton.click();
            modalWindow.shouldHave(Condition.text("Checkout"));
            nameCardField.setValue(nameCard);
            numberCardField.setValue(changeCard);
            yearButton.click();
            inputYearfield.setValue("2020").pressEnter();
            cvvField.setValue(cvv);

            saveButton.click();
           // refresh();
            modalElementWindow.waitUntil(Condition.disappear, 10000);

            errorRowTable.isDisplayed();

       //     $(By.tagName("th")).getText()=="Errors";

            if($(By.tagName("th")).getText()=="Errors"){
                System.out.println("Test filed");
            }
         //   removeButton.should(Condition.be(Condition.visible));

            //refresh();
           // removeButton.should(Condition.be(Condition.visible));

        } else if (errorText.isDisplayed()){
            errorText.shouldHave(Condition.text("An error occurred while processing your card. Try again in a little bit."));
            System.out.println("Test filed");
        }
    }


    public DriverLogInPage Logout(){

      //  accountButton.should(Condition.appear);
        accountButton.click();
        logoutButton.click();
        return page(DriverLogInPage.class);
    }


}
