package cn.itcast.jdbc.example.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCUtils {
    // 加载驱动，并建立数据库连接
    //定义一个public static方法getConnection，该方法会返回一个Connection对象
    //它可能会抛出SQLException和ClassNotFoundException。
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //加载MySQL的JDBC驱动
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8";//连接到数据库所需的JDBC URL
        String username = "root"; //数据库名称
        String password = "123456789"; //数据库密码
        // 使用DriverManager的getConnection方法，通过提供的URL、用户名和密码来建立与数据库的连接。
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn; //返回获取到的数据库连接。
    }
    // 关闭数据库连接，释放资源
    //定义一个public static方法release，该方法接收一个Statement和一个Connection作为参数
    public static void release(Statement stmt, Connection conn) {
        //检查Statement对象是否为null，如果不是，则关闭它，并捕获可能的SQLException。
        //之后，将Statement设置为null以确保资源被释放。
        if (stmt != null) {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) { //检查Connection对象是否为null
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
    //检查ResultSet是否为null，如果不是，则关闭ResultSet并处理可能的异常，然后将ResultSet设置为null。
    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(stmt, conn);  //调用上面定义的release方法来关闭Statement和Connection
    }
}

