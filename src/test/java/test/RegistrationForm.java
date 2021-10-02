package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationForm {
    public RegistrationForm() {
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        Selenide.$("#firstName").setValue("Robert");
        Selenide.$("#lastName").setValue("Shvarc");
        Selenide.$("#userEmail").setValue("robertqash@gmail.com");
        Selenide.$("#gender-radio-1").parent().click();
        Selenide.$("#userNumber").setValue("89017800000");
        Selenide.$("#dateOfBirthInput").click();
        Selenide.$(".react-datepicker__month-select").selectOption(new String[]{"April"});
        Selenide.$(".react-datepicker__year-select").selectOption(new String[]{"2000"});
        Selenide.$(".react-datepicker__day--019").click();
        Selenide.$("#subjectsInput").setValue("Maths").pressEnter();
        Selenide.$("#hobbies-checkbox-3").parent().click();
        Selenide.$("#uploadPicture").uploadFromClasspath(new String[]{"img/jdk.png"});
        Selenide.$("#currentAddress").setValue("Narodnogo fronta");
        Selenide.$("#react-select-3-input").setValue("NCR").pressEnter();
        Selenide.$("#react-select-4-input").setValue("Delhi").pressEnter();
        Selenide.$("#submit").click();
        Selenide.$(".table-responsive").shouldHave(new Condition[]{Condition.text("Robert"), Condition.text("Shvarc"), Condition.text("robertqash@gmail.com")});
        Selenide.$(".table-responsive").shouldHave(new Condition[]{Condition.text("Male"), Condition.text("19 April,2000")});
        Selenide.$(".table-responsive").shouldHave(new Condition[]{Condition.text("Maths"), Condition.text("Music"), Condition.text("jdk.png")});
        Selenide.$(".table-responsive").shouldHave(new Condition[]{Condition.text("Narodnogo fronta"), Condition.text("NCR Delhi")});
        Selenide.$("#closeLargeModal").click();
    }
}

