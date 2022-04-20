import com.codeborne.selenide.Configuration;
import data.DataGenerator;
import data.DbUtils;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.open;


public class VerificationTest {


    @Test
    void shouldVerification1() throws InterruptedException {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        val loginPage = new LoginPage();
        val authInfo = DataGenerator.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        TimeUnit.SECONDS.sleep(2);
        verificationPage.validCode();
    }

    @AfterAll
    static void dataDelete() {
       DbUtils cleaner = new DbUtils();
       cleaner.clean();
    }
}

