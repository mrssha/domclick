package ru.sbtqa.tag.pagefactoryexample.pages.Domclick;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by Maria on 15.06.2018.
 */


@PageEntry(title = "Выбранная квартира")
public class Flat extends Page {

    // Не находит элемент
    @ElementTitle("Квартира на одобрение")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[3]/div[2]/button")
    //@RedirectsTo(page = ShowListFlatsPage.class)
    public Button pressFlatToOK;


    public Flat() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }
}
