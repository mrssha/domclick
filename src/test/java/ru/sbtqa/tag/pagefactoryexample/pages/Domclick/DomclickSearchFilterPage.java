package ru.sbtqa.tag.pagefactoryexample.pages.Domclick;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.sbtqa.tag.pagefactoryexample.blocks.YandexMarket.HeaderBlock;
import ru.sbtqa.tag.pagefactoryexample.elements.YandexMarket.ProductCard;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

@PageEntry(title = "Фильтр поиска")
public class DomclickSearchFilterPage extends Page {

    @ElementTitle("Вторичка")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[1]/div[1]/div/label[1]/span")
    public Button vtorichka;

    @ElementTitle("Выбор города")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[1]/div[2]/span")
    public Button searchCity;

    //Город: Санкт-Петербург
    @Name("Город")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[1]/div[2]/div[2]/div/div/div/div[1]/input")
    public TextInput city;

    @ElementTitle("1 комната")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[2]/div/div/label[1]/span")
    public CheckBox oneRoom;

    @ElementTitle("2 комнаты")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[2]/div/div/label[2]/span")
    public CheckBox twoRooms;

    @ElementTitle("3 комнаты")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[2]/div/div/label[3]/span")
    public CheckBox threeRooms;

    //Цена: от 1000000 до 30000000
    @Name("Минимальная цена")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[3]/div/div[1]/input[1]")
    public TextInput fromPrice;

    @Name("Максимальная цена")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[3]/div/div[1]/input[2]")
    public TextInput toPice;

    @ElementTitle("Можно в ипотеку")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[1]/div/label[1]/span")
    public CheckBox ipoteka;

    @ElementTitle("Скидка 0,3% на ставку")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[1]/div/label[2]/span")
    public CheckBox skidka;


    //Площадь общая: от 30 до 100
    //Площадь кухни: от 8 до 15
    @ElementTitle("Площадь")
    public HeaderBlock headerBlock1;


    @ElementTitle("Не первый этаж")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[3]/div[1]/label[1]/span")
    public CheckBox notfirst;

    @ElementTitle("Не последний этаж")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[3]/div[1]/label[2]/span")
    public CheckBox notlast;

    // Этаж: от 5 до 15
    //Этажность: от 3 до 20


    @ElementTitle("Раздельный санузел")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[5]/div/label[2]/span")
    public CheckBox separated;

    /*
    @ElementTitle("Только с фото")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[6]/div/label[1]/span")
    public CheckBox onlyWithPhoto;
    */

    @ElementTitle("Балкон/лоджия")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[6]/div/label[2]/span")
    public CheckBox balcony;

    @ElementTitle("Показать списком")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[2]/div/a")
    @RedirectsTo(page = ShowListFlatsPage.class)
    public Button showList;






    @ElementTitle("Список товаров")
    @FindBy(xpath = ".//div[contains(@class,'n-snippet-card2 ')]")
    private List<ProductCard> productCards;

    public DomclickSearchFilterPage(){
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }


    @ActionTitle("проверяет присутствие продукта")
    public void compareProductCost(String productName){

        for (ProductCard card: productCards) {
            if(card.getProductName().toLowerCase().contains(productName.toLowerCase())){
                return;
            }
        }

        Assert.fail("Продукт " + productName +  " не был найден");
    }
}
