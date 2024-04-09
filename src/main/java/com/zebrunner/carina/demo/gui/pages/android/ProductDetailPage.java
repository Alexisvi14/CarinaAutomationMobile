package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailPageBase.class)
public class ProductDetailPage extends ProductDetailPageBase {

    @FindBy(css = "div[class='vi-title__main'] h1 span span")
    ExtendedWebElement productTitle;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }
}
