import com.codeborne.selenide.Configuration;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VerificationTest {

    @Test
    void shouldVerification(){
        val util = new DbUtils();


        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='login'] input").val();
        $("[data-test-id='password'] input").val();

    }
}
