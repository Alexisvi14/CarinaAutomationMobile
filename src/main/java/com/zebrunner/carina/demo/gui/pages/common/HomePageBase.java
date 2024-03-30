/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends AbstractPage {
    protected Logger logger;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        this.logger = LoggerFactory.getLogger(getClass());
    }

    public abstract LoginPageBase clickLoginButton();

    public abstract void clickSearchBox(String elementToSearch);

    public abstract void clickSearchButton();

    public abstract int getNumberOfSearchedElements();

    public abstract void hoverSportsLink();

    public abstract SportsPageBase clickSportsLink();

    public abstract void hoverFashionLinkAndSelectLink(String link);

    public abstract void clickCategoriesDropdown(int index) throws InterruptedException;

    public abstract void clickCloseAd();


}
