package ru.sbtqa.tag.pagefactoryexample.pages.Domclick;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


@PageEntry(title = "Домклик")
public class DomclickPage extends Page {

    @ElementTitle("Поиск по регионам")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/form/div[1]/div/span")
    public TextInput search;

    @ElementTitle("Начать подбор")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/form/div[2]/button")
    @RedirectsTo(page = DomclickSearchFilterPage.class)
    public Button startSearch;


    public DomclickPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    @ActionTitle("выбирает регион")
    public void searchRegion(String searchText){
        search.sendKeys(searchText);
        search.sendKeys(Keys.ENTER);
    }

}