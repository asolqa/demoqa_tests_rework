package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPageObjects;

public class TextBoxWithPageObjectsTest extends TestBase {
    TextBoxPageObjects textBoxPage = new TextBoxPageObjects();

    @Test
    void fillTextBoxFormTest() {
        textBoxPage.openPage()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submitForm()
                .checkResult();
    }
}
