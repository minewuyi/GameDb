package Dao;

import java.sql.*;

/**
 * @author wuyi
 * @date 2019/8/8 16:25
 */
public class SqlDao {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/my1905?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String password = "123456";
    private  static  Connection conn;
//数据库连接方法
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return conn;

    }
//数据库关闭方法
    public static void  closeConnection(Connection conn){
        if (conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
