package page;

import data.DbUtils;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    public DashboardPage validCode(){
        $("[data-test-id=code] input").val(DbUtils.getVerificationCode());
        $("[data-test-id='action-verify']").click();

        return new DashboardPage();
    }

}
