package ua.kiev.prog.jdbc.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Driver
    DriverManager
    DataSource
    Connection
    Statement
        PreparedStatement
        CallableStatement
    ResultSet
    SQLException
    close

    ORM
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flats_db",
                    "root", "root");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT id, name, group_id, email FROM Clients");
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getLong(3),
                        resultSet.getString(4)
                );
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
