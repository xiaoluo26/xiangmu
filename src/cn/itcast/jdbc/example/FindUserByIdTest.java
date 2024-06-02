package cn.itcast.jdbc.example;
import cn.itcast.jdbc.example.dao.UsersDao;
import cn.itcast.jdbc.example.domain.User;
public class FindUserByIdTest{
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao(); //创建一个UsersDao对象
        //调用usersDao对象的find方法，并传入ID值1作为参数
        //这个方法返回一个与ID为1的用户相对应的User对象，并将这个对象赋值给user变量
        User user = usersDao.find(1);
        System.out.println("id为1的User对象的name值为："+user.getUsername());//输出id为1的User对象的name值
    }
}
