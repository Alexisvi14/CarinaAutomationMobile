package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.demo.gui.pages.common.SportsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//a[@_sp='m570.l1524']")
    ExtendedWebElement loginButton;
    @FindBy(id = "kw")
    ExtendedWebElement searchBox;
    @FindBy(className = "gh-search__submitbtn")
    ExtendedWebElement searchButton;
    @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']")
    List<ExtendedWebElement> searchedElements;
    @FindBy(xpath = "//button[@class='gh-header-item__button gh__needs-js gh-header-item__menu']")
    ExtendedWebElement burguerMenu;
    @FindBy(xpath = "//span[contains(text(),'Categorías')]")
    ExtendedWebElement dropdownCategories;
    @FindBy(linkText = "Artículos deportivos")
    ExtendedWebElement sportsCategory;

    @FindBy(xpath = "//span[normalize-space()='Más']")
    ExtendedWebElement moreMenu;
    @FindBy(xpath = "(//a[contains(text(), 'Moda')])[2]")
    ExtendedWebElement fashionCategory;

    @FindBy(linkText = "Calzado")
    ExtendedWebElement footwear;

    @FindBy(css = "nav.vl-flyout-nav__sub-cat-col")
    List<ExtendedWebElement> fashionHoverList;

    @FindBy(id = "com.ebay.mobile:id/home_app_onboarding_screen_close")
    ExtendedWebElement closeAd;

    @FindBy(id = "com.ebay.mobile:id/search_src_text")
    ExtendedWebElement searchBoxText;
    @FindBy(xpath = "(//div[@class='s-item__image-wrapper image-treatment'])[2]")
    ExtendedWebElement firstSearchedElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void switchToWindow(){
        String parent = getDriver().getWindowHandle();
        Set<String> handles=getDriver().getWindowHandles();
        for (String handle:handles) {
            System.out.println(handle);
            if (!handle.equals(parent)){
                getDriver().switchTo().window(handle);
                break;
            }
        }
    }

    @Override
    public void clickBurguerMenu() {
        burguerMenu.click();
    }

    @Override
    public void clickLinkByText(String text) {
        getDriver().findElement(By.linkText(text)).click();
    }

    @Override
    public void clickMoreMenu() {
        moreMenu.click();
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
        sportsCategory.click();
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
    public void clickCategoriesLink() {
        dropdownCategories.click();
    }

    @Override
    public void clickCategoriesDropdown(String menuToSelect, String categoryToSelect) throws InterruptedException {
        selectDropdownElementByText(dropdownCategories, categoryToSelect);
        Thread.sleep(3000);
    }

    @Override
    public void clickCloseAd() {
        closeAd.click();
    }

    @Override
    public ProductDetailPageBase clickOnFirstElement() {
        firstSearchedElement.click();
        switchToWindow();
        return initPage(getDriver(), ProductDetailPageBase.class);
    }

    private void selectDropdownElementByIndex(ExtendedWebElement dropdown, int index){
        Select drop = new Select(dropdown.getElement());
        drop.selectByIndex(index);
    }

    private void selectDropdownElementByText(ExtendedWebElement dropdown, String text){
        Select drop = new Select(dropdown.getElement());
        drop.selectByVisibleText(text);
    }

}
