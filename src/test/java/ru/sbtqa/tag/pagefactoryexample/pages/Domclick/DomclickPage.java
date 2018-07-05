package ru.sbtqa.tag.pagefactoryexample.pages.Domclick;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


@PageEntry(title = "Домклик")
public class DomclickPage extends Page {

    @FindBy(xpath = "//h1[contains(text(),'ДомКлик')]")
    public TextInput titlePage;

    @FindBy(xpath = "//div[@class='offers-list']/a[3]")
    public TextInput imageWait;

    @ElementTitle("Поиск по регионам")
    @FindBy(xpath = "//span[@class='dropdown__value']")
    public Button searchRegion;

    @ElementTitle("Ввод города")
    @FindBy(xpath = "//div/input[@placeholder='Поиск по регионам']")
    public TextInput enterCity;

    @ElementTitle("Выбор города")
    @FindBy(xpath = "//div[@class='region-select__suggestion-name']")
    public Button chooseCity;

    @ElementTitle("Начать подбор/Показать")
    //@FindBy(xpath = "//button[text()='Начать подбор']")
    @FindBy(xpath = "//button[contains(text(),'Показать') or text()='Начать подбор']")
    @RedirectsTo(page = DomclickSearchFilterPage.class)
    public Button startSearch;


    public DomclickPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);

        new WebDriverWait(PageFactory.getDriver(), PageFactory.getTimeOutInSeconds())
                .until(ExpectedConditions.elementToBeClickable(searchRegion));

        new WebDriverWait(PageFactory.getDriver(), PageFactory.getTimeOutInSeconds())
                .until(ExpectedConditions.elementToBeClickable(imageWait));

    }


    @ActionTitle("ожидаем елемент")
    public void waitForElement(String elementString) throws PageException{

        WebElement element = this.getElementByTitle(elementString);

        new WebDriverWait(PageFactory.getDriver(), PageFactory.getTimeOutInSeconds())
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}