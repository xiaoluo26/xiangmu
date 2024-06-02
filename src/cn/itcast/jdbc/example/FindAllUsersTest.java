package cn.itcast.jdbc.example;
import java.util.ArrayList;
import cn.itcast.jdbc.example.dao.UsersDao;
import cn.itcast.jdbc.example.domain.User;
public class FindAllUsersTest{
    public static void main(String[] args) {
        //创建一个名称为usersDao的对象
        UsersDao usersDao = new UsersDao();
        //调用usersDao对象的findAll方法，并将返回的用户列表赋值给list变量
        ArrayList<User> list = usersDao.findAll();
        //遍历list集合，并输出其中的数据
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "条数据的username值为:" + list.get(i).getUsername());
        }
    }
}
