package com.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.BlogInfo;
import com.entity.User;
import com.util.DBconn;

public class UserDaoImpl implements UserDao{

    public boolean register(User user) {
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("insert into user(name,pwd) " + "values('" + user.getName() + "','" + user.getPwd() + "')");
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public boolean login(String name, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("SELECT * FROM user WHERE name='" + name + "'");
            while(rs.next()){
                if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public List<BlogInfo> getUserAll() {
        List<BlogInfo> list = new ArrayList<BlogInfo>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("SELECT * FROM BlogInfo");
            while (rs.next()) {
                BlogInfo blogInfo = new BlogInfo();
                blogInfo.setId(rs.getInt("id"));
                blogInfo.setName(rs.getString("name"));
                blogInfo.setInfo(rs.getString("Info"));
                blogInfo.setTag(rs.getString("tag"));
                blogInfo.setDate(rs.getDate("date"));
                list.add(blogInfo);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean update(int id,String name, String pwd) {
        boolean flag = false;
        DBconn.init();
        String sql ="update user set name ='"+name
                +"' , pwd ='"+pwd
                +"' where id = "+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from bloginfo where id=" + id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public boolean addinfo(BlogInfo bloginfo){
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("insert into bloginfo(name,info,tag,date) " + "values('" + bloginfo.getName() + "','" + bloginfo.getInfo() + "','" + bloginfo.getTag() + "','" + bloginfo.getDate() + "')");
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

}