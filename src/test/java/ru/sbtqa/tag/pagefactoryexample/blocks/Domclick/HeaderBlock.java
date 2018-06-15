package ru.sbtqa.tag.pagefactoryexample.blocks.Domclick;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

@Name("Площадь")
@FindBy(xpath = "//*[@id=\"content\"]/div/main/div/div[1]/div[2]/form/div/div[4]/div[2]")
public class HeaderBlock extends HtmlElement{

    @Name("Общая_от")
    @FindBy(xpath = "//*[@id=\"squareTotalFrom\"]")
    public TextInput generalFrom;

    @Name("Общая_до")
    @FindBy(xpath = "//*[@id=\"squareTotalTo\"]")
    public TextInput generalTo;

    @Name("Кухня_от")
    @FindBy(xpath = "//*[@id=\"squareKitchenFrom\"]")
    public TextInput kitchenFrom;

    @Name("Кухня_до")
    @FindBy(xpath = "//*[@id=\"squareKitchenTo\"]")
    public TextInput kitchenTo;


    @ActionTitle("задает значения")
    public void startSearch(List<String> args){
        generalFrom.sendKeys(args.get(0));
        generalFrom.sendKeys(Keys.ENTER);
        generalTo.sendKeys(args.get(1));
        generalTo.sendKeys(Keys.ENTER);

        kitchenFrom.sendKeys(args.get(2));
        kitchenFrom.sendKeys(Keys.ENTER);
        kitchenTo.sendKeys(args.get(3));
        kitchenTo.sendKeys(Keys.ENTER);
    }


}
