package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPageObjects;

public class PracticeFormWithPageObjectsTest extends TestBase {
    PracticeFormPageObjects practiceFormPage = new PracticeFormPageObjects();

    @Test
    void fillFullFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Vlad")
                .setLastName("Petrov")
                .setEmail("vlad@petrov.com")
                .setGender("Male")
                .setNumber("9876543210")
                .setDateOfBirth("01", "June", "2000")
                .setSubject("Math")
                .setHobbies("Music")
                .uploadFile()
                .setAddress("Some street")
                .setState("Haryana")
                .setCity("Karnal")
                .submitForm();

        //Assertions
        practiceFormPage.checkResult("Student Name", "Vlad Petrov")
                .checkResult("Student Email", "vlad@petrov.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9876543210")
                .checkResult("Date of Birth", "01 June,2000")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "avatar.png")
                .checkResult("Address", "Some street")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void fillMinDataSetTest() {
        //Name, gender, number
        practiceFormPage.openPage()
                .setFirstName("Vlad")
                .setLastName("Petrov")
                .setGender("Male")
                .setNumber("9876543210")
                .submitForm();

        //Assertions
        practiceFormPage.checkResult("Student Name", "Vlad Petrov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9876543210");
    }

    @Test
    void negativeNoNumberTest () {
        //Name, gender but no number
        practiceFormPage.openPage()
                .setFirstName("Vlad")
                .setLastName("Petrov")
                .setGender("Male")
                .submitForm();

        //Assertions
       practiceFormPage.checkNoModal();
    }

    @Test
    void negativeWrongEmailTest () {
        //Name, gender, number, wrong format email
        practiceFormPage.openPage()
                .setFirstName("Vlad")
                .setLastName("Petrov")
                .setEmail("vladpetrov.com")
                .setGender("Male")
                .setNumber("9876543210")
                .submitForm();

        //Assertions
        practiceFormPage.checkNoModal();
    }
}
