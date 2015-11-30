package com.selenide_pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by babych on 23.11.2015.
 */
public class DotApplications {

    @FindBy(how = How.XPATH, using = ".//*[@id='side-menu']/li[2]/a")
            public SelenideElement settingsButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='DataTables_Table_0']/tbody/tr")
            public ElementsCollection sizeTable;

    @FindBy(how = How.LINK_TEXT, using = "View application")
            public SelenideElement vievButton;

    @FindBy(how = How.TAG_NAME, using = "h2")
            public SelenideElement textViewPage;

    @FindBy(how = How.CSS, using = ".dropdown-toggle.btn.btn-link")
            public SelenideElement accountButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[1]/nav/div/div/ul/li[3]/a")
            public SelenideElement logoutButton;

    @FindBy(how = How.CSS, using ="#DataTables_Table_0_info")
            public SelenideElement firstEllofTable;


    String nameLink;

    //визначаю кількість рядків  і  рандомно вибираю з них число
    public int randomNumber(){
        int  sizeOflist =  sizeTable.size();
        int randomLinkNumber = (int) (Math.random() * (sizeOflist -1));
        if(randomLinkNumber==0) {                      //перший елемент таблиці 1, а рандомом може випасти 0
            randomLinkNumber = 1;
        }
       return randomLinkNumber;
    }

    public VeiwPage ClickViewApplication(){
        int vupadok = randomNumber();           //для того щоб функція не змінювала значення

            SelenideElement randButton = $(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr["+vupadok+"]")).find(By.cssSelector(".btn.btn-success.dropdown-toggle"));
            nameLink = $(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr["+ vupadok +"]/td[2]")).getText();
            randButton.click();

            vievButton.click();
            textViewPage.shouldHave(text(nameLink));  //перевірка чи текст співпадає
            return page(VeiwPage.class);
    }

    public boolean EmptyTBL(){
        boolean empty = false;
        if (firstEllofTable.has(text("Showing 0 to 0 of 0 entries"))){
            empty = true;
        }
        return empty;
    }

    public void isRowsPresent(){
        if (EmptyTBL()==false){
            ClickViewApplication();
            System.out.println("Table is full");
            Logout();
        }else if (EmptyTBL()==true){
            System.out.println("Table is empty");
            Logout();
        }
    }

    public DriverLogInPage Logout(){
        accountButton.click();
        logoutButton.click();
        return page(DriverLogInPage.class);
    }

    public SettingsPage openSettings(){
        settingsButton.click();
        return page(SettingsPage.class);
    }

}
