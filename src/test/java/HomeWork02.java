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
                DofB = "26",
                MofB = "September",
                YofB = "2010",
                L_Subjects = "b",
                Subjects = "Biology",
                Hobby = "Reading",
                Pic = "1.JPG",
                Address = "Len wosse, 1r2",
                State = "Haryana",
                City = "Panipat";



        open(link);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").val(fname);
        $("#lastName").val(lname);
        $("#userEmail").val(email);
        $(byText(gender)).shouldBe(exist ).click();
        //$(byText("Male")).should(present ).click();
        //$("#genterWrapper gender-radio-1").shouldHave(text("Male")).click();
        $("#userNumber").val(mob_nom);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(MofB);
        //$(byText(MofB)).click();
        //sleep(10000);
        $(".react-datepicker__year-select").selectOption(YofB);
        //$(byText(YofB)).click();
        //sleep(10000);
        $(".react-datepicker__day--0" + DofB).click();
        //sleep(10000);
        //Subjects
        $("#subjectsInput").val(L_Subjects);
        $(byText(Subjects)).click();

        $(byText(Hobby)).shouldBe(exist ).click();
        //Select picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + Pic));
        $(byText("Picture")).scrollTo();
        $("#currentAddress").val(Address);
        $("#state").click();
        $(byText(State)).click();
        $("#city").click();
        $(byText(City)).click();
        $("#submit").click();

        //проверка
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byText("Student Name")).parent().shouldHave(text(fname + " " + lname));
        $(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-hover").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").find(byText("Mobile")).parent().shouldHave(text(mob_nom));
        $(".table-hover").$(byText("Date of Birth")).parent().shouldHave(text(DofB + " " + MofB + "," + YofB));
        $(".table-hover").find(byText("Subjects")).parent().shouldHave(text(Subjects));
        $(".table-hover").find(byText("Hobbies")).parent().shouldHave(text(Hobby));
        $(".table-hover").find(byText("Picture")).parent().shouldHave(text(Pic));
        $(".table-hover").find(byText("Address")).parent().shouldHave(text(Address));
        $(".table-hover").find(byText("State and City")).parent().shouldHave(text(State + " " + City));
        $("#closeLargeModal").click();


        //System.out.println("Successfully");
    }

}
