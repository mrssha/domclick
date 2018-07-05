package ru.sbtqa.tag.pagefactoryexample.pages.Domclick;

import cucumber.api.java.en.But;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Conditional;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 15.06.2018.
 */


@PageEntry(title = "Выбранная квартира")
public class Flat extends Page {

    /*
    @FindBy(xpath = "//span[@class='_1QhbO']")
    @ElementTitle("Квартира на одобрение")
    public Button pressFlatToOK;

    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[2]/div/div/div/div/button[1]/span")
    @ElementTitle("Отправить")
    public Button sendToOK;
    */

    @FindBy(xpath = "//button[@title='Добавить в избранное']")
    @ElementTitle("Сохранить")
    public Button save;

    @FindBy(xpath = "//span/a[contains(text(),'Перейти к сохраненным')]")
    //div[@class='fav-message']/span/a
    @ElementTitle("Перейти к сохраненным")
    @RedirectsTo(page = FavoritesPage.class)
    public Button goToFavorites;


    public Flat() {

        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);

        new WebDriverWait(PageFactory.getDriver(), PageFactory.getTimeOutInSeconds())
                .until(ExpectedConditions.elementToBeClickable(save));

        /*
        WebDriver driver = new ChromeDriver();
        //driver.get("http://somedomain/url_that_delays_loading");
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<WebElement>(){
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.id("myDynamicElement"));

                    }});
                    */

        //PageFactory.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //this.assertModalWindowAppears("Объективна ли цена в объявлении?");
        //PageFactory.getTimeOutInSeconds();
    }

    /*
    public void waitForElementApear(WebElement element) {
        WebDriver driver = new ChromeDriver();
        WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return element;
            }
        });
    }
    */


}
