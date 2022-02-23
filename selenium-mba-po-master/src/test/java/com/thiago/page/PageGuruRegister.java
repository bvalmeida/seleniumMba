package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageGuruRegister extends CorePage<PageGuruRegister> {

    public PageGuruRegister(){
        this.driver = TLDriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
    private WebElement firstName;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")
    private WebElement lastName;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")
    private WebElement phone;

    @FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement email;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")
    private WebElement address;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input")
    private WebElement city;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")
    private WebElement stateProvince;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement userName;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")
    private WebElement password;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")
    private WebElement confirmPassword;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input")
    private WebElement send;

//  CONFIRMAÇÃO

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")
    private WebElement nameRegister;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a")
    private WebElement signIn;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b")
    private WebElement userNameConfirm;

    @FindBy(xpath = "//*[@id=\"dismiss-button\"]/div/span")
    private WebElement ad;

//  LOGIN

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input")
    private WebElement userNameLogin;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
    private WebElement passwordLogin;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input")
    private WebElement submitLogin;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")
    private WebElement confirmLogin;

    public void guruRegister(String element){

        preencherCampo(firstName, element);
        preencherCampo(lastName, element);
        preencherCampo(phone, element);
        preencherCampo(email, element);
        preencherCampo(address, element);
        preencherCampo(city, element);
        preencherCampo(stateProvince, element);
        preencherCampo(postalCode, element);
        preencherCampo(userName, element);
        preencherCampo(password, element);
        preencherCampo(confirmPassword, element);
        aguardarElementoClicado(send);
        click(send);

        // Confirmação

        Assert.assertEquals(getTextElement(nameRegister), "Dear breno breno,");
        Assert.assertEquals(getTextElement(userNameConfirm), "Note: Your user name is breno.");
        click(signIn);

        // Login

        aguardarElementoVisivel(userNameLogin);
        preencherCampo(userNameLogin, element);
        preencherCampo(passwordLogin, element);
        aguardarElementoClicado(submitLogin);
        click(submitLogin);

        // Confirmar login

        aguardarElementoVisivel(confirmLogin);
        Assert.assertEquals(getTextElement(confirmLogin), "Login Successfully");
    }






}
