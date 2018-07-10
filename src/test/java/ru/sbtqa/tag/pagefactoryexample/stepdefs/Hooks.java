package ru.sbtqa.tag.pagefactoryexample.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.PageFactory;

/**
 * Created by Maria on 08.07.2018.
 */
public class Hooks {

    @Before
    public void prepareData() {
        Singleton.getInstance()
                .setWebDriverWaiter(new WebDriverWait(PageFactory.getDriver(), PageFactory.getTimeOutInSeconds()));
    }

}