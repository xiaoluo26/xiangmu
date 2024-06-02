package cn.itcast.jdbc.example;

import cn.itcast.jdbc.example.dao.UsersDao;
public class DeleteUserTest{
    public static void main(String[] args) {
        // 删除操作
        UsersDao usersDao = new UsersDao();//创建了一个UsersDao对象
        //调用usersDao对象的delete方法，并传入参数4，这个方法会删除数据库中ID为4的用户记录，并返回一个布尔值来表示删除操作是否成功。
        //这个返回值（true表示成功，false表示失败）存在变量b中
        boolean b = usersDao.delete(4);
        System.out.println(b);//在控制台打印结果
    }
}
