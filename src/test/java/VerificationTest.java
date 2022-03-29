import com.codeborne.selenide.Configuration;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VerificationTest {

    @Test
    void shouldVerification() {
        DbUtils db = new DbUtils();
        User us = db.getUser();

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='login'] input").val(us.getLogin());
        $("[data-test-id='password'] input").val(us.getPassword());

    }
}
