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
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
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
    @FindBy(xpath = "//span[text()='Вторичка']")
    public Button vtorichka;

    @ElementTitle("Поиск по регионам")
    @FindBy(xpath = "//div[@class='region-select']/span")
    public Button  searchRegion;

    @ElementTitle("1 комната")
    //span[text()='1']
    //label[input[@name='rooms']]/span[text()='1']
    @FindBy(xpath = "//label[input[@name='rooms' and @id='0']]/span")
    public CheckBox oneRoom;

    @ElementTitle("2 комнаты")
    @FindBy(xpath = "//label[input[@name='rooms' and @id='1']]/span")
    public CheckBox twoRooms;

    @ElementTitle("3 комнаты")
    @FindBy(xpath = "//label[input[@name='rooms' and @id='2']]/span")
    public CheckBox threeRooms;


    @ElementTitle("Минимальная цена")
    @FindBy(xpath = "//input[@name='price__gte']")
    public TextInput fromPrice;

    @ElementTitle("Максимальная цена")
    @FindBy(xpath = "//input[@name='price__lte']")
    public TextInput toPrice;

    //контрол убрали
    @ElementTitle("Можно в ипотеку")
    @FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[1]/div/label[1]/span")
    public CheckBox ipoteka;


    @ElementTitle("Скидка 0,3% на ставку")
    @FindBy(xpath = "//label[input[@name='discounts']]/span")
    public CheckBox skidka;


    //Площадь общая: от 30 до 100
    //Площадь кухни: от 8 до 15
    @ElementTitle("Общая площадь от")
    @FindBy(xpath = "//input[@name='area__gte']")
    public TextInput generalFrom;

    @ElementTitle("Общая площадь до")
    @FindBy(xpath = "//input[@name='area__lte']")
    public TextInput generalTo;

    @ElementTitle("Кухня от")
    @FindBy(xpath = "//input[@name='kitchen_space__gte']")
    public TextInput kitchenFrom;

    @ElementTitle("Кухня до")
    @FindBy(xpath = "//input[@name='kitchen_space__lte']")
    public TextInput kitchenTo;




    @ElementTitle("Не первый этаж")
    @FindBy(xpath = "//label[input[@name='floor_not_first']]/span")
    public CheckBox notfirst;

    @ElementTitle("Не последний этаж")
    @FindBy(xpath = "//label[input[@name='floor_not_last']]/span")
    public CheckBox notlast;

    // Этаж: от 5 до 15
    //Этажность: от 3 до 20
    @ElementTitle("Этаж от")
    @FindBy(xpath = "//input[@name='floor__gte']")
    public TextInput floorFrom;

    @ElementTitle("Этаж до")
    @FindBy(xpath = "//input[@name='floor__lte']")
    public TextInput floorTo;

    @ElementTitle("Этажность от")
    @FindBy(xpath = "//input[@name='floors__gte']")
    public TextInput allFloorFrom;

    @ElementTitle("Этажность до")
    @FindBy(xpath = "//input[@name='floors__lte']")
    public TextInput allFloorTo;

    @ElementTitle("Раздельный санузел")
    @FindBy(xpath = "//label[input[@name='separated_bathroom']]/span")
    public CheckBox separated;

    @ElementTitle("Только с фото")
    @FindBy(xpath = "//label[input[@name='with_photo']]/span")
    public CheckBox onlyWithPhoto;

    @ElementTitle("Балкон/лоджия")
    @FindBy(xpath = "//label[input[@name='balconies']]/span")
    public CheckBox balcony;

    @ElementTitle("Показать списком")
    @FindBy(xpath = "//span[@class='offers-on-map__total']")
    @RedirectsTo(page = ShowListFlatsPage.class)
    public Button showList;


    public DomclickSearchFilterPage(){
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);

        new WebDriverWait(PageFactory.getDriver(), PageFactory.getTimeOutInSeconds())
                .until(ExpectedConditions.elementToBeClickable(showList));

    }

    /*
    @ActionTitle("проверяем текст элемента")
    public void checkNameField(String nameField){
        Assert.assertEquals("Неверный текст элемнта " + searchRegion.getName(), searchRegion.getAttribute("after"), nameField);

    }
    *
    */

    @ActionTitle("проверяем статус чекбоксов")
    public void checkStatus(){
        System.out.println(oneRoom.isSelected());
        System.out.println(twoRooms.isSelected());
        System.out.println(threeRooms.isSelected());
        System.out.println(onlyWithPhoto.isSelected());
    }

}
