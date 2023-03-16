package org.example.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TXTest {
    @Test
    public void insert()  {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            // 开启事务
            connection.setAutoCommit(false);
            // 张三转出500
            String sql = " UPDATE account SET balance = balance - ? WHERE username = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1, 500);
            pstmt.setObject(2, "张三");
            pstmt.executeUpdate();

            // 模拟异常
            int i = 10 / 0;

            // 李四转入500
            sql = " UPDATE account SET balance = balance + ? WHERE username = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1, 500);
            pstmt.setObject(2, "李四");
            pstmt.executeUpdate();

            // 提交事物
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        } finally {
            if(null != pstmt) {
                try {
                     pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != connection) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
