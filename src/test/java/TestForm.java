import com.codeborne.selenide.Configuration;
import org.pages.MainFormPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
public class TestForm{
    private MainFormPage formPage;

    @BeforeClass
    void init(){
        Configuration.baseUrl = "https://practice-automation.com/form-fields/";
        Configuration.browserSize = "1920x1080";
        //Configuration.browser = "edge";
        Configuration.timeout = 30000;

        open(Configuration.baseUrl);
        formPage = page(MainFormPage.class);
    }

    @Test(description = "Проверка ввода имени", priority = 1)
    void testSetFirstNameField() {
        formPage.setName("Stepan");
    }

    @Test(description = "Проверка ввода пароля", priority = 2)
    void testSetIdField() {
        formPage.setPassword("123456");
    }

    @Test(description = "Выбор чекбокса Milk", priority = 3)
    void selectCheckBoxDrink2() {
        formPage.clickCheckBox2();
    }

    @Test(description = "Выбор чекбокса Coffee", priority = 4)
    void selectCheckBoxDrink3() {
        formPage.clickCheckBox3();
    }

    @Test(description = "Выбор чекбокса Yellow", priority = 5)
    void clickRadio3() {
        formPage.clickRadio3();
    }

    @Test(description = "Выбор варианта из выпадающего списка", priority = 6)
    void selectAutomationOption() {
        formPage.selectRandomAutomationOption();
    }

    @Test(description = "Проверка ввода почты", priority = 7)
    void testSetEmailField() {
        formPage.setEmailField("stepan@yandex.ru");
    }

    @Test(description = "Проверка Message", priority = 8)
    void testSetMessage() {
        formPage.setCountMessage();
    }

    @Test(description = "Нажатие кнопки submit и проверка полей", priority = 9)
    void testClickSubmitButton() {
        formPage.clickSubmitButton();
        sleep(10000);
    }
}
