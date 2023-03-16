package org.example.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest2 {
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Before
    public void Before() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void insert() throws SQLException, FileNotFoundException {
        String sql = "INSERT INTO `user`(username, password, photo) VALUES (?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "lisi");
        preparedStatement.setString(2, "123456");
        preparedStatement.setBlob(3, new FileInputStream("C:\\Users\\he\\Pictures\\发布课程信息.png"));
        int executeUpdate = preparedStatement.executeUpdate();
        System.out.println("executeUpdate = " + executeUpdate);
    }

    @Test
    public void insertMuti() throws SQLException {
        String sql = "INSERT INTO `user`(username, password) VALUES (?,?)";
        preparedStatement = connection.prepareStatement(sql);
        for(int i = 1; i <= 100000; i ++) {
            preparedStatement.setString(1, String.valueOf(i));
            preparedStatement.setString(2,String.valueOf(i));
            // “攒”sql
            preparedStatement.addBatch();
            if(i % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
    }

    @After
    public void after() {
        if(null != preparedStatement) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null != connection) {
            try{
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
