package com.zebrunner.carina.demo.gui.pages.android;

import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @FindBy(id = "userid")
    ExtendedWebElement usernameBox;
    @FindBy(id = "pass")
    ExtendedWebElement passwordBox;
    @FindBy(id = "signin-continue-btn")
    ExtendedWebElement continueButton;
    @FindBy(css = "#signin-error-msg")
    ExtendedWebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickUsernameBox(String username) {
        usernameBox.type(username);
    }

    @Override
    public void clickPasswordBox(String password) {
        passwordBox.type(password);
    }

    @Override
    public void clickContinueButton() {
        continueButton.click();
    }

    @Override
    public String getErrorMsg() {
        return errorMsg.getText();
    }
}
