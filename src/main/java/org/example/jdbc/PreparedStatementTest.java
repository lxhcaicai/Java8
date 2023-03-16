package org.example.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class PreparedStatementTest {
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

    /**
     *
     * 增加
     *
     * @throws SQLException
     */
    @Test
    public void insert() throws SQLException {
        String sql = " INSERT INTO `user`(username, password) VALUES(?,?) ";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "zhangsan");
        preparedStatement.setString(2, "123456");
        int executeUpdate = preparedStatement.executeUpdate();
        System.out.println("executeUpdate = " + executeUpdate);
    }

    /**
     * 删除
     * @throws SQLException
     */
    @Test
    public void delete() throws SQLException {
        String sql = "DELETE FROM `user` WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        int executeUpdate = preparedStatement.executeUpdate();
        System.out.println("executeUpdate = " + executeUpdate);
    }


    @Test
    public void update() throws SQLException {
        String sql = "UPDATE `user` SET password = ? WHERE username = ? ";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "12345");
        preparedStatement.setString(2, "test");
        int executeUpdate = preparedStatement.executeUpdate();
        System.out.println("executeUpdate = " + executeUpdate);
    }

    /**
     * 查询
     * @throws SQLException
     */
    @Test
    public void query() throws SQLException {
        String sql = "SELECT * FROM `user` WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 2);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String password2 = rs.getString(3);
            System.out.println("id = " + id + "，username = " + username + "，password = " + password2);
        }
    }


    @Test
    public void insert2() throws SQLException {
        String sql = " INSERT INTO `user` (username,password) VALUES (?,?) ";
        preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, "zhangsan");
        preparedStatement.setString(2, "123456");

        int executeUpdate = preparedStatement.executeUpdate();
        System.out.println("executeUpdate = " + executeUpdate);

        // 获取自增长的key值
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if(rs.next()) {
            Object key = rs.getObject(1);
            System.out.println("key = " + key);
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
