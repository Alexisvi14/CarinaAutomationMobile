package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class EbayTests implements IAbstractTest {

    @BeforeMethod
    public void openChrome(){
        getDriver().get("https://www.ebay.com");
    }

//                      ESTE CASO NO SE PUEDE LLEVAR A CABO POR INCLUSION DE CAPTCHAS
//    @Test(dataProvider="usernameData")
//    @MethodOwner(owner = "Alexis")
//    public void loginButtonTest(String username) throws InterruptedException {
//        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        MobileContextUtils mobileContextUtils = new MobileContextUtils();
//        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_CHROME);
//        var loginPage = homePage.clickLoginButton();
//        loginPage.clickUsernameBox(username);
//        loginPage.clickContinueButton();
//        Thread.sleep(3000);
//        System.out.println(Thread.currentThread().getId());
//        Assert.assertEquals(loginPage.getErrorMsg(),
//                "No pudimos encontrar esta cuenta de eBay.", "El mensaje no fue el esperado");
//        Assert.assertTrue(!loginPage.getErrorMsg().isEmpty());
//
//    }
    @DataProvider
    public Object[][] usernameData(){
        Object[][] data = new Object[3][1];
        data[0][0] = "hellohellojajagmail";
        data[1][0] = "ahsdiusjndkasndujewkiu";
        data[2][0] = "iu32whuewhut21t21y";
        return data;
    }

    @Test(description = "Text Box functionality")
    @MethodOwner(owner = "Alexis")
    public void searchButtonTest() {
        HomePageBase homePageEbay = initPage(getDriver(), HomePageBase.class);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_CHROME);
        homePageEbay.clickSearchBox("Iphone");
        homePageEbay.clickSearchButton();
        var productDetailPage = homePageEbay.clickOnFirstElement();
        String title = productDetailPage.getProductTitle();
        System.out.println(title);
        Assert.assertTrue(productDetailPage.isTitlePresent());
    }

    @Test(description = "Fashion link articles")
    public void submenuElements() throws InterruptedException {
        HomePageBase homePageEbay = initPage(getDriver(), HomePageBase.class);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_CHROME);
        homePageEbay.clickBurguerMenu();
        homePageEbay.clickCategoriesLink();
        homePageEbay.clickLinkByText("Moda");
        Thread.sleep(5000);
//        Assert.assertTrue();
    }

    @Test(description = "All categories dropdown")
    public void dropdownTest() throws InterruptedException {
        HomePageBase homePageEbay = initPage(getDriver(), HomePageBase.class);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_CHROME);
        homePageEbay.clickBurguerMenu();
        homePageEbay.clickCategoriesLink();
        homePageEbay.clickLinkByText("Todas las categorías");
        Thread.sleep(5000);
    }

    @Test(description = "Sports link articles")
    public void clickSportsLinkTest() throws InterruptedException {
        HomePageBase homePageEbay = initPage(getDriver(), HomePageBase.class);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_CHROME);
        homePageEbay.clickBurguerMenu();
        homePageEbay.clickCategoriesLink();
        var sportsPage = homePageEbay.clickSportsLink();
        Thread.sleep(5000);
        Assert.assertTrue(sportsPage.isTitlePresent());
    }
    @Test(description = "Sports link functionality")
    public void sportList() {
        HomePageBase homePageEbay = initPage(getDriver(), HomePageBase.class);
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_CHROME);
        homePageEbay.clickBurguerMenu();
        homePageEbay.clickCategoriesLink();
        var sportsPage = homePageEbay.clickSportsLink();
        sportsPage.clickSection("Golf");
    }
}
