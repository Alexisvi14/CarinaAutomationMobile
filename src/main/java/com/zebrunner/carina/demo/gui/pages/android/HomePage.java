package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.SportsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//a[@_sp='m570.l1524']")
    ExtendedWebElement loginButton;
    @FindBy(className = "gh-tb")
    ExtendedWebElement searchBox;
    @FindBy(id = "gh-btn")
    ExtendedWebElement searchButton;
    @FindBy(css = "div#srp-river-results li")
    List<ExtendedWebElement> searchedElements;
    @FindBy(id = "gh-cat")
    ExtendedWebElement dropdownCategories;
    @FindBy(linkText = "Deportes")
    ExtendedWebElement sportsCategory;
    @FindBy(xpath = "(//a[contains(text(), 'Moda')])[2]")
    ExtendedWebElement fashionCategory;
    @FindBy(linkText = "Calzado")
    ExtendedWebElement footwear;

    @FindBy(css = "nav.vl-flyout-nav__sub-cat-col")
    List<ExtendedWebElement> fashionHoverList;

    @FindBy(id = "com.ebay.mobile:id/home_app_onboarding_screen_close")
    private ExtendedWebElement closeAd;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public void clickSearchBox(String elementToSearch) {
        searchBox.type(elementToSearch);
    }

    @Override
    public void clickSearchButton() {
        searchButton.click();
    }

    @Override
    public int getNumberOfSearchedElements() {
        logger.info(String.valueOf(searchedElements.size()));
        return searchedElements.size();
    }

    @Override
    public void hoverSportsLink() {
        sportsCategory.hover();
    }

    @Override
    public SportsPageBase clickSportsLink() {
        return initPage(getDriver(), SportsPageBase.class);
    }

    @Override
    public void hoverFashionLinkAndSelectLink(String link) {
        fashionCategory.hover();
        fashionHoverList.forEach(e -> {
            if (e.getText().equalsIgnoreCase(link)){
                e.click();
            }
        });
    }

    @Override
    public void clickCategoriesDropdown(int index) throws InterruptedException {
        selectDropdownElementByIndex(dropdownCategories, index);
        Thread.sleep(3000);
    }

    @Override
    public void clickCloseAd() {
        closeAd.click();
    }

    private void selectDropdownElementByIndex(ExtendedWebElement dropdown, int index){
        Select drop = new Select(dropdown.getElement());
        drop.selectByIndex(index);
    }
}
