package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageGuruDrag extends CorePage<PageGuruDrag> {

    public PageGuruDrag() {
        this.driver = TLDriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "fourth")
    private WebElement click1;

    @FindBy(id = "credit")
    private WebElement click2;

    @FindBy(id = "credit2")
    private WebElement click3;

    @FindBy(id = "credit1")
    private WebElement click4;

    @FindBy(id = "credit3")
    private WebElement click5;

    @FindBy(id = "credit4")
    private WebElement click6;

    @FindBy(id = "bank")
    private WebElement space1;

    @FindBy(id = "loan")
    private WebElement space2;

    @FindBy(id = "amt7")
    private WebElement space3;

    @FindBy(id = "amt8")
    private WebElement space4;

    @FindBy(id = "equal")
    private WebElement confirm;

    public void guruDrag(){

        arrastarAlgumaCoisa(click1, space1);
        arrastarAlgumaCoisa(click1, space2);
        arrastarAlgumaCoisa(click1, space3);
        arrastarAlgumaCoisa(click1, space4);

        arrastarAlgumaCoisa(click2, space1);
        arrastarAlgumaCoisa(click2, space2);
        arrastarAlgumaCoisa(click2, space3);
        arrastarAlgumaCoisa(click2, space4);

        arrastarAlgumaCoisa(click3, space1);
        arrastarAlgumaCoisa(click3, space2);
        arrastarAlgumaCoisa(click3, space3);
        arrastarAlgumaCoisa(click3, space4);

        arrastarAlgumaCoisa(click4, space1);
        arrastarAlgumaCoisa(click4, space2);
        arrastarAlgumaCoisa(click4, space3);
        arrastarAlgumaCoisa(click4, space4);

        arrastarAlgumaCoisa(click5, space1);
        arrastarAlgumaCoisa(click5, space2);
        arrastarAlgumaCoisa(click5, space3);
        arrastarAlgumaCoisa(click5, space4);

        arrastarAlgumaCoisa(click6, space1);
        arrastarAlgumaCoisa(click6, space2);
        arrastarAlgumaCoisa(click6, space3);
        arrastarAlgumaCoisa(click6, space4);

        aguardarElementoVisivel(confirm);
        Assert.assertEquals(getTextElement(confirm), "Perfect!");
    }
}
