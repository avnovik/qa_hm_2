import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork02 {

    @Test
    void fillFormTest() {
        String  link = "https://demoqa.com/automation-practice-form",
                fname = "James",
                lname = "Bond",
                email = "007@agent.com",
                gender = "Male",
                mob_nom = "0123456789",
                dofB = "26",
                mofB = "September",
                yofB = "2010",
                l_subjects = "b",
                subjects = "Biology",
                hobby = "Reading",
                pic = "1.JPG",
                address = "Len wosse, 1r2",
                state = "Haryana",
                city = "Panipat";
        open(link);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").val(fname);
        $("#lastName").val(lname);
        $("#userEmail").val(email);
        $(byText(gender)).shouldBe(exist ).click();
        $("#userNumber").val(mob_nom);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(mofB);
        $(".react-datepicker__year-select").selectOption(yofB);
        $(".react-datepicker__day--0" + dofB).click();
        $("#subjectsInput").val(l_subjects);
        $(byText(subjects)).click();
        $(byText(hobby)).shouldBe(exist ).click();
        //Select picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + pic));
        $(byText("Picture")).scrollTo();
        $("#currentAddress").val(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        //проверка
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byText("Student Name")).parent().shouldHave(text(fname + " " + lname));
        $(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-hover").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").find(byText("Mobile")).parent().shouldHave(text(mob_nom));
        $(".table-hover").$(byText("Date of Birth")).parent().shouldHave(text(dofB + " " + mofB + "," + yofB));
        $(".table-hover").find(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-hover").find(byText("Hobbies")).parent().shouldHave(text(hobby));
        $(".table-hover").find(byText("Picture")).parent().shouldHave(text(pic));
        $(".table-hover").find(byText("Address")).parent().shouldHave(text(address));
        $(".table-hover").find(byText("State and City")).parent().shouldHave(text(state + " " + city));
    }
}
