package tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Открытие и заполнение всех полей формы", () -> {
            registrationPage.openPage()
                    .cleanBanner()
                    .setFirstName("Pavel")
                    .setLastName("Milyukov")
                    .setUserEmail("milyukov@yandex.ru")
                    .setGender("Male")
                    .setNumber("0123456789")
                    .setDateOfBirth("16", "January", "1993")
                    .setSubjects("Computer Science")
                    .setHobbies("Sports")
                    .setPicture("bag.png")
                    .setAddress("ул.Ленина")
                    .setState("NCR")
                    .setCity("Noida")
                    .submit();

        });
        step("Проверка формы", () -> {
            registrationPage
                    .checkTableResponse("Student Name", "Pavel Milyukov")
                    .checkTableResponse("Student Email", "milyukov@yandex.ru")
                    .checkTableResponse("Gender", "Male")
                    .checkTableResponse("Mobile", "0123456789")
                    .checkTableResponse("Date of Birth", "16 January,1993")
                    .checkTableResponse("Subjects", "Computer Science")
                    .checkTableResponse("Hobbies", "Sports")
                    .checkTableResponse("Picture", "bag.png")
                    .checkTableResponse("Address", "ул.Ленина")
                    .checkTableResponse("State and City", "NCR Noida");

    });
        step("Открытие и заполнение минимального количества полей формы", () -> {
            registrationPage.openPage()
                    .cleanBanner()
                    .setFirstName("Pavel")
                    .setLastName("Milyukov")
                    .setUserEmail("milyukov@yandex.ru")
                    .setGender("Male")
                    .setNumber("0123456789")
                    .setDateOfBirth("16", "January", "1993")
                    .setHobbies("Sports")
                    .setAddress("ул.Ленина")
                    .submit();
        });
        step("Проверка формы", () -> {
            registrationPage
                    .checkTableResponse("Student Name", "Pavel Milyukov")
                    .checkTableResponse("Student Email", "milyukov@yandex.ru")
                    .checkTableResponse("Gender", "Male")
                    .checkTableResponse("Mobile", "0123456789")
                    .checkTableResponse("Date of Birth", "16 January,1993")
                    .checkTableResponse("Hobbies", "Sports")
                    .checkTableResponse("Address", "ул.Ленина");
        });


    }
}