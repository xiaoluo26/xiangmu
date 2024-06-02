package cn.itcast.jdbc.example;
import java.util.Date;
import cn.itcast.jdbc.example.dao.UsersDao;
import cn.itcast.jdbc.example.domain.User;
public class UpdateUserTest{
    public static void main(String[] args) {
        // 修改User对象的数据
        UsersDao usersDao = new UsersDao(); //创建了一个UsersDao对象
        User user = new User(); //创建了一个新的User对象
        user.setId(4); //设置user对象的id属性为4
        user.setUsername("zhaoxiaoliu"); //设置user对象的username属性为"zhaoxiaoliu"
        user.setPassword("456");
        user.setEmail("zhaoxiaoliu@sina.com");
        user.setBirthday(new Date());
        //调用usersDao对象的update方法，并将修改后的user对象作为参数传入
        //update方法执行数据库更新操作，返回一个布尔值来表示更新是否成功，返回值被存在变量b中
        boolean b = usersDao.update(user);
        System.out.println(b); //在控制台上打印变量b的值，如果更新操作成功，打印true，否则，打印false
    }
}
