import com.entity.User;
import com.util.DBconn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/blogsql";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps =null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.out.println("init [SQL驱动程序初始化失败！]");
            e.printStackTrace();
        }

        String name = "zhangsan";
        String pwd = "123456";

        boolean flag = false;
        try {                   //("select * from user where name='" + name + "' and pwd='" + pwd + "'")
            DBconn.init();
            rs = DBconn.selectSql("SELECT * FROM user WHERE name='" + name + "'");
            while(rs.next()){
                if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){
                    flag = true;
                }
            }
            System.out.println(flag);
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}