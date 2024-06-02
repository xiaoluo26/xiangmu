package cn.itcast.jdbc.example;
import java.util.Date;
import cn.itcast.jdbc.example.dao.UsersDao;
import cn.itcast.jdbc.example.domain.User;
public class JdbcInsertTest{
    public static void main(String[] args) {
        // 向users表插入一个用户信息
        UsersDao ud = new UsersDao();//创建了一个UsersDao对象ud
        User user=new User();//创建了一个新的User对象user，包含用户的相关信息
        user.setId(5);//设置user对象的id属性为5
        user.setUsername("hl");//设置user对象的username属性为"hl"
        user.setPassword("123");
        user.setEmail("hl@sina.com");
        user.setBirthday(new Date());//设置user对象的birthday属性为当前日期和时间，用Date类来获取当前日期和时间
        //调用ud对象的insert方法，将前面创建的user对象插入到数据库中
        //insert方法返回一个布尔值，表示插入操作是否成功，返回值被存储在变量b中
        boolean b=ud.insert(user);
        System.out.println(b);//如果插入操作成功，打印true，否则，打印false
    }
}

