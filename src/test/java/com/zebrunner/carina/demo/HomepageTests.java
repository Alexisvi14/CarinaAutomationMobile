package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.android.HomePage;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomepageTests implements IAbstractTest {

//                      ESTE CASO NO SE PUEDE LLEVAR A CABO POR INCLUSION DE CAPTCHAS
    @Test(dataProvider="usernameData")
    @MethodOwner(owner = "Alexis")
    public void loginButtonTest(String username) throws InterruptedException {
        HomePage homePage = (HomePage) initPage(getDriver(), HomePageBase.class);
        var loginPage = homePage.clickLoginButton();
        loginPage.clickUsernameBox(username);
        loginPage.clickContinueButton();
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getId());
        Assert.assertEquals(loginPage.getErrorMsg(),
                "No pudimos encontrar esta cuenta de eBay.", "El mensaje no fue el esperado");
        Assert.assertTrue(!loginPage.getErrorMsg().isEmpty());

    }
    @DataProvider
    public Object[][] usernameData(){
        Object[][] data = new Object[3][1];
        data[0][0] = "hellohellojajagmail";
        data[1][0] = "ahsdiusjndkasndujewkiu";
        data[2][0] = "iu32whuewhut21t21y";
        return data;
    }
    @Test()
    public void searchButtonTest() throws InterruptedException {
        HomePage homePageEbay = new HomePage(getDriver());
        System.out.println("Thread ID is: " + Thread.currentThread().getId());
        homePageEbay.clickCloseAd();
        homePageEbay.clickSearchBox("Iphone");
        homePageEbay.clickSearchButton();
        Thread.sleep(5000);

        Assert.assertEquals(homePageEbay.getNumberOfSearchedElements(), 123, "The number of elements did not match");
    }

    @Test()
    public void submenuElements() throws InterruptedException {
        HomePage homePageEbay = new HomePage(getDriver());
        homePageEbay.hoverFashionLinkAndSelectLink("Calzado");
        Thread.sleep(5000);
//        Assert.assertTrue();
    }

    @Test()
    public void dropdownTest() throws InterruptedException {
        HomePage homePageEbay = new HomePage(getDriver());
        homePageEbay.clickCategoriesDropdown(2);
        homePageEbay.clickSearchButton();
        String artTitle = getDriver().findElement(By.cssSelector("h1.title-banner__title")).getText();
        Assert.assertEquals(artTitle, "Arte", "The title shown was not correct");
    }

    @Test()
    public void hoverSportsTest(){
        HomePage homePageEbay = new HomePage(getDriver());
        homePageEbay.hoverSportsLink();
//        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Vende con eBay")));
//        Assert.assertTrue(link.isDisplayed());
//        link.click();
    }
    @Test()
    public void sportList() throws InterruptedException {
        HomePage homePageEbay = new HomePage(getDriver());
        var sportsPage = homePageEbay.clickSportsLink();
        String sportsTitle = getDriver().findElement(By.cssSelector("h1.title-banner__title")).getText();
        Assert.assertTrue(sportsTitle.startsWith("Artículos"));
        sportsPage.iterateCategorySection("Equipo de Boxeo y MMA");
    }
}
