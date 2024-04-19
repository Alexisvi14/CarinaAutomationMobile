package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SportsPageBase extends AbstractPage {
    protected Logger logger;

    public SportsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public abstract void iterateCategorySection(String linkToSelect);

    public abstract boolean isTitlePresent();
    public abstract void clickSection(String section);
}
