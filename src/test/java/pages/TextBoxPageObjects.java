package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.util.Objects.requireNonNull;

public class TextBoxPageObjects {
    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputUserName = $("#output #name"),
            outputUserEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPageObjects openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }
    public TextBoxPageObjects setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }
    public TextBoxPageObjects setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public TextBoxPageObjects setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPageObjects setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public TextBoxPageObjects submitForm() {
        submitButton.click();

        return this;
    }
    @SuppressWarnings("UnusedReturnValue")
    public TextBoxPageObjects checkResult() {
        outputUserName.shouldHave(text(requireNonNull(userNameInput.getValue())));
        outputUserEmail.shouldHave(text(requireNonNull(userEmailInput.getValue())));
        outputCurrentAddress.shouldHave(text(requireNonNull(currentAddressInput.getValue())));
        outputPermanentAddress.shouldHave(text(requireNonNull(permanentAddressInput.getValue())));

        return this;
    }
}
