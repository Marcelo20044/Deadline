package data;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtils {
    QueryRunner runner = new QueryRunner();

    public static String getVerificationCode() {
        QueryRunner runner = new QueryRunner();

        String idSQL = "SELECT id FROM users WHERE login = 'vasya';";

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


    public void clean() {
        QueryRunner runner = new QueryRunner();

        var codesSQL = "DELETE FROM auth_codes WHERE TRUE;";
        var cardsSQL = "DELETE FROM cards WHERE TRUE;";
        var usersSQL = "DELETE FROM users WHERE TRUE;";

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            runner.update(conn, codesSQL);
            runner.update(conn, cardsSQL);
            runner.update(conn, usersSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}



