package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoginPageBase extends AbstractPage {
    protected Logger logger;

    public LoginPageBase(WebDriver driver) {
        super(driver);
        this.logger = LoggerFactory.getLogger(this.getClass());
    }
    public abstract void clickUsernameBox(String username);
    public abstract void clickPasswordBox(String password);
    public abstract void clickContinueButton();
    public abstract String getErrorMsg();
}
