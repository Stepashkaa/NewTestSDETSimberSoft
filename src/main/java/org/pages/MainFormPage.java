package org.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.ElementsCollection;
import java.util.Random;
import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainFormPage {

    @FindBy(xpath = "//input[@id='name-input']")
    private SelenideElement nameField;

    @FindBy(xpath = "//input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(xpath = "//input[@id='drink2']")
    private SelenideElement checkBoxDrink2;

    @FindBy(xpath = "//input[@id='drink3']")
    private SelenideElement checkBoxDrink3;

    @FindBy(xpath = "//input[@id='color3']")
    private SelenideElement radioColor3;

    @FindBy(xpath = "//select[@id='automation']")
    private SelenideElement automationSelect;

    @FindBy(xpath = "//input[@id='email']")
    private SelenideElement emailField;

    @FindBy(xpath = "//ul[not(@id) and not(@type)]")
    private SelenideElement countMessage;

    @FindBy(xpath = "//textarea[@id='message']")
    private SelenideElement message;

    @FindBy(xpath = "//button[@id='submit-btn']")
    private SelenideElement submitButton;

    public MainFormPage setName(String name){
        nameField.shouldBe(appear).setValue(name);
        return this;
    }

    public MainFormPage setPassword(String password){
        passwordField.shouldBe(appear).setValue(password);
        return this;
    }

    public MainFormPage clickCheckBox2(){
        checkBoxDrink2.shouldBe(Condition.visible).click();
        return this;
    }
    public MainFormPage clickCheckBox3(){
        checkBoxDrink3.shouldBe(Condition.visible).click();
        return this;
    }

    public MainFormPage clickRadio3(){
        radioColor3.shouldBe(Condition.visible).click();
        return this;
    }

    public MainFormPage selectRandomAutomationOption(){
        ElementsCollection options = automationSelect.$$("option");
        Random rand = new Random();
        int randomIndex = rand.nextInt(options.size());
        options.get(randomIndex).click();
        return this;
    }

    public MainFormPage setEmailField(String email) {
        emailField
                .shouldBe(visible)
                .setValue(email)
                .shouldHave(value(email));
        return this;
    }

    public MainFormPage setCountMessage(){
        int itemCount = countMessage.$$("li").size();
        message
                .shouldHave(visible)
                .setValue(String.valueOf(itemCount))
                .shouldHave(value(String.valueOf(itemCount)));
        return this;
    }

    public MainFormPage clickSubmitButton(){
        submitButton
                .shouldHave(visible)
                .click();
        return this;
    }
}
