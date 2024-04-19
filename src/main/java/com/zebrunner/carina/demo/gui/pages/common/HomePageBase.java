package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends AbstractPage implements IMobileUtils {
    protected Logger logger;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract LoginPageBase clickLoginButton();

    public abstract void clickSearchBox(String elementToSearch);

    public abstract void clickSearchButton();

    public abstract int getNumberOfSearchedElements();

    public abstract void hoverSportsLink();

    public abstract SportsPageBase clickSportsLink();

    public abstract void hoverFashionLinkAndSelectLink(String link);

    public abstract void clickCategoriesLink();

    public abstract void clickCategoriesDropdown(String menuToSelect, String categoryToSelect) throws InterruptedException;

    public abstract void clickCloseAd();

    public abstract ProductDetailPageBase clickOnFirstElement();

    public abstract void switchToWindow();

    public abstract void clickBurguerMenu();

    public abstract void clickLinkByText(String text);

    public abstract void clickMoreMenu();
}
