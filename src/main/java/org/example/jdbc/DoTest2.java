package org.example.jdbc;

import org.junit.Test;

import java.sql.*;

public class DoTest2 {
    @Test
    public void testAdd() throws SQLException, ClassNotFoundException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "root";
        // 获取连接
        Connection connection = DriverManager.getConnection(url,user, password);
        // 创建Statement对象
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO `user`(username, password) VALUES ('admin','123456')";

        // 发送SQL 并获取结果
        int update = statement.executeUpdate(sql);
        System.out.println("update = " + update);

        // 关闭资源
        statement.close();
        connection.close();
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "root";
        // 获取连接
        Connection connection = DriverManager.getConnection(url,user, password);
        // 创建Statement对象
        Statement statement = connection.createStatement();

        String sql = "UPDATE `user` SET password = 'root' WHERE username = 'admin' ";

        // 发送SQL 并获取结果
        int update = statement.executeUpdate(sql);
        System.out.println("update = " + update);

        // 关闭资源
        statement.close();
        connection.close();
    }

    @Test
    public void testQuery() throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "root";

        // 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 创建Statement对象
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String pwd = resultSet.getString(3);
            System.out.println("id = " + id + "，username = " + username + "，password = " + pwd);
        }

        // 关闭资源
        statement.close();
        connection.close();
    }

    @Test
    public void testDel() throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "root";

        // 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 创建Statement对象
        Statement statement = connection.createStatement();
        // 准备SQL
        String sql = "DELETE FROM `user` ";
        int update = statement.executeUpdate(sql);
        System.out.println("update = " + update);

        // 关闭资源
        statement.close();
        connection.close();
    }
}
