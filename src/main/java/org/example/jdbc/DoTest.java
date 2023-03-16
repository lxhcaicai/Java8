package org.example.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DoTest {
    @Test
    public void testConnection1() throws SQLException {
        //1.提供java.sql.Driver接口实现类的对象
        Driver driver = null;
        driver = new com.mysql.jdbc.Driver();
        //2.提供url，指明具体操作的数据
        String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";

        //3.提供Properties的对象，指明用户名和密码
        Properties info  = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");

        Connection connection = driver.connect(url, info);
        System.out.println(connection);
    }

    // 示例：相较于方式一，这里使用反射实例化 Driver，不在代码中体现第三方数据库的 API 。体现了面向接口编程思想。
    @Test
    public void testConnection2() {
       try {
           String className = "com.mysql.cj.jdbc.Driver";
           Class clazz = Class.forName(className);
           Driver driver = (Driver) clazz.newInstance();

           //2.提供url，指明具体操作的数据
           String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";

           //3.提供Properties的对象，指明用户名和密码
           Properties info  = new Properties();
           info.setProperty("user","root");
           info.setProperty("password","root");

           Connection connection = driver.connect(url, info);
           System.out.println(connection);

       } catch (Exception e) {
           e.printStackTrace();
       }

    }

    // 方式三 使用 DriverManager 实现数据库的连接。体会获取连接必要的 4 个基本要素
    @Test
    public void testConnection3() {
        try {
            String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String user = "root";
            String password = "root";
            String driverName = "com.mysql.cj.jdbc.Driver";

            // 实例化 Driver
            Class clazz = Class.forName(driverName);
            Driver driver = (Driver) clazz.newInstance();
            // 注册驱动
            DriverManager.registerDriver(driver);
            // 获取连接
            Connection connection = DriverManager.getConnection(url,user, password);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 不必显式的注册驱动了。因为在 DriverManager 的源码中已经存在静态代码块，实现了驱动的注册
    @Test
    public void testConnection4() {
        try {
            //1.数据库连接的4个基本要素：
            String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String user = "root";
            String password = "root";
            String driverName = "com.mysql.cj.jdbc.Driver";
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 示例：使用配置文件的方式保存配置信息，在代码中加载配置文件
    // 配置文件声明在工程的 src 目录下：【jdbc.properties】
    @Test
    public void testConnection5() throws IOException, ClassNotFoundException, SQLException {
        //1.加载配置文件
        InputStream is = DoTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        //3.加载驱动
        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user,password);
        System.out.println(connection);
    }
}
