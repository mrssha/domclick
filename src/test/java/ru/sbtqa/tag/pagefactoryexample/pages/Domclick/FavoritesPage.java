package ru.sbtqa.tag.pagefactoryexample.pages.Domclick;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactoryexample.stepdefs.Singleton;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


/**
 * Created by Maria on 19.06.2018.
 */

@PageEntry(title = "Сохраненные квартиры")
public class FavoritesPage extends Page {

    @ElementTitle("Первая сохраненная квартира")
    @FindBy(xpath = "//div[@class='favorites-offers']/a[1]")
    public Button firstSavedFlat;

    public FavoritesPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);

        Singleton.getInstance().getWebDriverWaiter()
                .until(ExpectedConditions.elementToBeClickable(firstSavedFlat));

        /*
        new WebDriverWait(PageFactory.getDriver(), PageFactory.getTimeOutInSeconds())
                .until(ExpectedConditions.elementToBeClickable(firstSavedFlat));
                */
    }

    @ActionTitle("проверяем идендификатор квартиры в избранном")
    public void checkResult() {
        String flatLaterChosen = ShowListFlatsPage.getChosenFlatId();
        String flatInFavorites = firstSavedFlat.getAttribute("href");
        Assert.assertEquals("Неверный идендификатор квартиры в избранном", flatLaterChosen, flatInFavorites);
    }

}
