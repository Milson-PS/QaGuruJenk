package tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @Tag("demoqa")
    void fillFormTest() {
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