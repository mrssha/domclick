package ru.sbtqa.tag.pagefactoryexample.stepdefs;

import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maria on 09.07.2018.
 */
public class Singleton {
    private static Singleton instance;

    private WebDriverWait waiter;

    private Singleton() {
    }

    ;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public WebDriverWait getWebDriverWaiter() {
        return waiter;
    }

    public void setWebDriverWaiter(WebDriverWait waiter) {
        this.waiter = waiter;
    }
}