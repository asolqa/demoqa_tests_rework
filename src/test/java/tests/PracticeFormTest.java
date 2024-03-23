package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {
    @Test
    void fillFullFormTest() {
        open("/automation-practice-form");

        //Name, email, gender, number
        $("#firstName").setValue("Vlad");

        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("vlad@petrov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9876543210");

        //Date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-select").$(byText("June")).click();
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();

        //Subjects
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //File
        $("#uploadPicture").uploadFromClasspath("avatar.png");

        //Address
        $("#currentAddress").setValue("Some street");

        //State
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        //City
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        //Assertions
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Vlad"), text("Petrov"),
                text("vlad@petrov.com"), text("9876543210"));
    }

    @Test
    void fillMinDataSetTest(){
        open("/automation-practice-form");

        //Name, gender, number
        $("#firstName").setValue("Vlad");
        $("#lastName").setValue("Petrov");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9876543210");

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Vlad"), text("Petrov"),
                text("Male"), text("9876543210"));
    }

    @Test
    void negativeNoNumberTest () {
        open("/automation-practice-form");

        //Name, gender but no number
        $("#firstName").setValue("Vlad");
        $("#lastName").setValue("Petrov");
        $("#genterWrapper").$(byText("Male")).click();

        $("#submit").click();

        $(".modal-dialog").shouldNot(appear);
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeWrongEmailTest () {
        open("/automation-practice-form");

        //Name, gender, number, wrong format email
        $("#firstName").setValue("Vlad");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("vladpetrov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9876543210");

        $("#submit").click();

        $(".modal-dialog").shouldNot(appear);
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
}
