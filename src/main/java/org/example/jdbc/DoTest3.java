package org.example.jdbc;

import java.sql.*;
import java.util.Scanner;

public class DoTest3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.next();
        System.out.print("请输入密码：");
        String pwd = scanner.next();

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
        String sql = "SELECT id, username, password FROM `user` WHERE username ='" + name + "' and password = '" + pwd + "'";
        System.out.println("sql = " + sql);
        // 发送SQL
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String password2 = rs.getString(3);
            System.out.println("id = " + id + "，username = " + username + "，password = " + password2);
        }

        // 关闭资源
        statement.close();
        connection.close();
    }
}
