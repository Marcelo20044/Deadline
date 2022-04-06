import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtils {
    QueryRunner runner = new QueryRunner();


    public User getUser() {

        String userSQL = "SELECT * FROM users;";

        User user = null;
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            user = runner.query(conn, userSQL, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public String getPasswordByLogin() {
        String password = "123qwerty";

        return password;
    }


    public String getVerificationCode() {
        String idSQL = "SELECT id FROM users WHERE login = 'petya';";

        String id = null;
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            id = runner.query(conn, idSQL, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String codeSQL = "SELECT code FROM auth_codes WHERE user_id ='" + id + "'ORDER BY created DESC;";


        String code = null;

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            code = runner.query(conn, codeSQL, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return code;
    }


}

