package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailPageBase extends AbstractPage {

    public ProductDetailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitle();
    public abstract void switchToWindow();

    public abstract boolean isTitlePresent();
}
