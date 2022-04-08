import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VerificationTest {

    @Test
    void shouldVerification() throws InterruptedException {
        DbUtils db = new DbUtils();
        User us = db.getUser();

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='login'] input").val(us.getLogin());
        $("[data-test-id='password'] input").val(db.getPasswordByLogin());
        $("[data-test-id=action-login]").click();
        TimeUnit.SECONDS.sleep(2);
        $("[data-test-id=code] input").val(db.getVerificationCode());
        $("[data-test-id='action-verify']").click();
        $("[id='root']").shouldBe(Condition.visible)
                 .shouldHave(text("Личный кабинет"));

    }
}
