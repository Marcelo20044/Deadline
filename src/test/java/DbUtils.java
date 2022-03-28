import com.github.javafaker.Faker;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtils {
    QueryRunner runner = new QueryRunner();


    public void getUser() {
        var loginSQL = "SELECT * FROM users;";

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            User first = runner.query(conn, loginSQL, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

