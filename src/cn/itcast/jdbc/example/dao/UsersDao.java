package cn.itcast.jdbc.example.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import cn.itcast.jdbc.example.domain.User;
import cn.itcast.jdbc.example.utils.JDBCUtils;
public class UsersDao {
    // 添加用户的操作（增删改查）
    //定义一个公共方法insert，它接收一个User对象作为参数，并返回一个布尔值表示是否插入成功
    public boolean insert(User user) { //定义与数据库连接相关的对象：
        Connection conn = null; //与数据库连接的Connection对象
        Statement stmt = null; //用于执行SQL语句的Statement对象
        ResultSet rs = null; //查询结果的ResultSet对象
        try {
            // 获得数据库的连接，并将该连接赋值给conn变量
            conn = JDBCUtils.getConnection();
            // 创建一个Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            //创建了一个SimpleDateFormat对象sdf，用于将日期格式化为"yyyy-MM-dd"的形式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //使用sdf的format方法来格式化用户对象user的生日属性，并将结果字符串赋值给birthday变量
            String birthday = sdf.format(user.getBirthday());
            //构造了一个SQL INSERT语句，用于向users表中插入一个新的记录
            //它使用字符串拼接的方式将用户对象user的属性值插入到SQL语句中
            String sql = "INSERT INTO users(id,name,password,email,birthday) "+ "VALUES("
                    + user.getId()
                    + ",'"
                    + user.getUsername()
                    + "','"
                    + user.getPassword()
                    + "','"
                    + user.getEmail()
                    + "','"
                    + birthday + "')";
            //使用stmt对象的executeUpdate方法来执行SQL INSERT语句，该方法返回一个整数，表示受影响的行数
            //如果受影响的行数大于0（在这里，等于1，因为INSERT语句只插入一行），那么方法返回true，表示插入成功。否则，返回false
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn); //调用JDBCUtils类的release方法来释放与数据库相关的资源
        }
        return false;
    }
    // 查询所有的User对象
    //方法findAll，用于从数据库中的users表检索所有用户记录，并将它们封装在User对象的列表中返回
    public ArrayList<User> findAll() {
        Connection conn = null; //定义一个Connection对象conn，并初始化为null。这个对象将用于与数据库建立连接
        Statement stmt = null; //定义一个Statement对象stmt，并初始化为null。这个对象将用于执行SQL查询
        ResultSet rs = null; //定义一个ResultSet对象rs，并初始化为null。这个对象将用于存储从数据库查询返回的结果集
        //创建一个新的ArrayList对象list（动态数组列表），用于存储从数据库检索到的所有User对象
        ArrayList<User> list = new ArrayList<User>();
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句：定义一个SQL查询字符串sql，用于从users表中选择所有记录
            String sql = "SELECT * FROM users";
            rs = stmt.executeQuery(sql);//使用Statement对象stmt执行SQL查询，并将结果集赋值给rs
            // 处理结果集
            while (rs.next()) { //开始一个循环，遍历结果集中的每一行
                //为结果集中的每一行创建一个新的User对象，并将这些数据映射到一个User对象上，然后将这个对象添加到一个列表中
                User user = new User();
                //从结果集中提取每一行的数据，并设置到User对象的相应属性中
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name")); // 从当前行获取"name"列的值，并设置为User对象的username属性
                user.setPassword(rs.getString("password")); // 从当前行获取"pass"列的值，并设置为User对象的password属性
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                list.add(user);//将填充了数据的User对象添加到list列表中
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //调用JDBCUtils类的release方法来释放与数据库相关的资源（ResultSet、Statement和Connection）
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    // 根据id查找指定的user对象
    public User find(int id) {
        //初始化三个数据库相关对象
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句，构造一个SQL查询语句，从users表中查询ID等于给定id的用户的所有字段
            String sql = "SELECT * FROM users WHERE id=" + id;//通过字符串拼接，将这两个部分合并成一个完整的SQL查询字符串
            rs = stmt.executeQuery(sql); //执行SQL查询语句，并将结果集赋值给rs
            // 处理结果集
            while (rs.next()) { //开始一个循环，遍历结果集中的每一行
                //查询成功并且找到了匹配的行，那么ResultSet对象rs将包含这些行（预期结果集只包含1行或0行）
                //为结果集中的每一行创建一个新的User对象，并将这些数据映射到一个User对象上，然后将这个对象添加到一个列表中
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //调用JDBCUtils类的release方法来释放与数据库相关的资源（ResultSet、Statement和Connection）
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    // 删除用户，定义了一个delete方法
    public boolean delete(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句，构造一个SQL删除语句，从users表中删除ID等于给定id的用户记录
            String sql = "DELETE FROM users WHERE id=" + id;//通过字符串拼接，将这两个部分合并成一个完整的SQL查询字符串
            int num = stmt.executeUpdate(sql);//执行SQL删除语句，并返回受影响的行数。如果成功删除了用户记录，num的值将大于0
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //调用JDBCUtils类的release方法来释放与数据库相关的资源（ResultSet、Statement和Connection）
            JDBCUtils.release(rs, stmt, conn);
        }
        //可省略，由于return语句在try块或catch块中已经被执行，最后的return false，实际上永远不会被执行到
        return false;
    }
    // 修改用户，更新数据库中users表中特定用户的记录
    public boolean update(User user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            //创建一个SimpleDateFormat对象sdf用于格式化日期
            //然后使用它将User对象的birthday属性格式化为字符串，并赋值给birthday变量
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(user.getBirthday());
            //将User对象的属性值拼接到SQL语句中，"UPDATE users"指定了要更新的表名为users
            //通过set关键字指定了要更新的字段及其新值，值从User对象中获取，如name字段被设置为user.getUsername()的返回值
            String sql = "UPDATE users set name='" + user.getUsername()
                    + "',password='" + user.getPassword() + "',email='"
                    + user.getEmail() + "',birthday='" + birthday
                    //WHERE id=" + user.getId()指定了更新操作的条件，即只更新id字段值等于user.getId()返回值的记录
                    + "' WHERE id=" + user.getId();
            //执行SQL更新语句，并返回受影响的行数。如果成功更新了用户记录，num的值将大于0
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //调用JDBCUtils类的release方法来释放与数据库相关的资源（ResultSet、Statement和Connection）
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }
}

