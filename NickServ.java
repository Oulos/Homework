package server;

import java.sql.*;

// Hello from mIRC

public class NickServ {

    private Connection connection;
    private Statement stmt;


    private void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:chat_db.db");
        stmt = connection.createStatement();
    }

    private void disconnect() {
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int register (String login, String nickname, String password) {
        int result = 0;
        try {
            connectToDB();
            result = stmt.executeUpdate("INSERT INTO users (login, nickname, password) VALUES ('"+login+"', '"+nickname+"', '"+password+"');");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return result;
    }

    public String identify (String login, String password) {
        String result = null;
        try {
            connectToDB();
            ResultSet rs = stmt.executeQuery("SELECT nickname FROM users WHERE (login = '"+login+"') AND (password = '"+password+"');");
            while (rs.next()){
                result = rs.getString("nickname");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return result;
    }



}
