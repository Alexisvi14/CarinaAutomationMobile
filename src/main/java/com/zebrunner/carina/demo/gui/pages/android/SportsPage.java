package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.SportsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SportsPage extends SportsPageBase {

    @FindBy(xpath = "//li[@class='b-links-accordion']")
    List<ExtendedWebElement> categoriesLinks;

    public SportsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void iterateCategorySection(String linkToSelect){
        for (ExtendedWebElement link : categoriesLinks) {
            String dropdownText = link.getText();
            if (dropdownText.equalsIgnoreCase(linkToSelect)){
                link.click();
                break;
            }
        }
    }
}
