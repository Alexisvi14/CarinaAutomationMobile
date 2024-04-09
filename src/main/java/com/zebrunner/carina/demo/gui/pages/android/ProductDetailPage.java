package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailPageBase.class)
public class ProductDetailPage extends ProductDetailPageBase {

    @FindBy(css = "h1[class='x-item-title__mainTitle'] span[class='ux-textspans ux-textspans--BOLD']")
    ExtendedWebElement productTitle;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void switchToWindow(){
        Set<String> handles=getDriver().getWindowHandles();
        Iterator it=handles.iterator();
        String parent= (String) it.next();
        if (((String) it.next()).isEmpty()){
            getDriver().switchTo().window(parent);
        }else {
            String child=(String) it.next();
            getDriver().switchTo().window(child);
        }
    }

    @Override
    public boolean isTitlePresent() {
        return productTitle.isPresent();
    }


    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }
}
