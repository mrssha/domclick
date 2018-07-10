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

@PageEntry(title = "Список квартир")
public class ShowListFlatsPage extends Page {

    private static String chosenFlatId;

    @ElementTitle("Первая квартира в списке")
    @FindBy(xpath = "//div[@class='offers-list']/a[1]")
    @RedirectsTo(page = Flat.class)
    public Button firstInList;

    public ShowListFlatsPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);

        Singleton.getInstance().getWebDriverWaiter()
                .until(ExpectedConditions.elementToBeClickable(firstInList));


        chosenFlatId = firstInList.getAttribute("href");
    }

    public static String getChosenFlatId() {
        return chosenFlatId;
    }

}
