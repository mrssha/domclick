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
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by Maria on 15.06.2018.
 */

@PageEntry(title = "Список квартир")
public class ShowListFlatsPage extends Page {


    @ElementTitle("Результаты поиска")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div/div[2]/div[1]/div[2]")
    private List<Link> results;

    @ElementTitle("Первая квартира в списке")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div/div[2]/div[1]/div[2]/a[1]/div[2]")
    @RedirectsTo(page = Flat.class)
    public Button firstInList;


    public ShowListFlatsPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }


    //Так не работает
    @ActionTitle("выбирает из списка квартиру номер")
    public void chooseFlat(String number){
        int num = Integer.parseInt(number);

        results.get(num-1).sendKeys(Keys.ENTER);
    }

}
