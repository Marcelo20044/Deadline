import com.github.javafaker.Faker;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtils {
    QueryRunner runner = new QueryRunner();


    public User getUser() {
        var dataSQL = "SELECT * FROM users;";

        User user = null;
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            user = runner.query(conn, dataSQL, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}

