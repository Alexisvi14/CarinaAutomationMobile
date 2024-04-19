package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.SportsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SportsPageBase.class)
public class SportsPage extends SportsPageBase {

    @FindBy(xpath = "//li[@class='b-links-accordion']")
    List<ExtendedWebElement> categoriesLinks;

    @FindBy(css = ".b-pageheader__text")
    ExtendedWebElement sportsTitle;

    @FindBy(xpath = "(//span[@role='listitem'])")
    List<ExtendedWebElement> sportsSection;

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

    @Override
    public boolean isTitlePresent() {
        return sportsTitle.isPresent();
    }

    @Override
    public void clickSection(String sectionLink) {
        for (ExtendedWebElement element: sportsSection) {
            String linkText = element.getText();
            if (linkText.equalsIgnoreCase(sectionLink)){
                element.click();
                break;
            }
        }
    }
}
