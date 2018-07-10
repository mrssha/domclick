package ru.sbtqa.tag.pagefactoryexample.pages.Domclick;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.sbtqa.tag.pagefactoryexample.stepdefs.Singleton;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


/**
 * Created by Maria on 15.06.2018.
 */


@PageEntry(title = "Выбранная квартира")
public class Flat extends Page {

    @FindBy(xpath = "//button[@title='Добавить в избранное']")
    @ElementTitle("Сохранить")
    public Button save;

    @FindBy(xpath = "//span/a[contains(text(),'Перейти к сохраненным')]")
    @ElementTitle("Перейти к сохраненным")
    @RedirectsTo(page = FavoritesPage.class)
    public Button goToFavorites;


    public Flat() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);

        Singleton.getInstance().getWebDriverWaiter()
                .until(ExpectedConditions.elementToBeClickable(save));

    }

}
