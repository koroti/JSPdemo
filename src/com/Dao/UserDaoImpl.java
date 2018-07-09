package com.Dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
  
import com.Entity.USER;  
import com.Util.DBconn;  
  
public class UserDaoImpl implements UserDao{  
      
    public boolean register(USER user) {  
        boolean flag = false;  
        DBconn.init();  
        int i =DBconn.addUpdDel("insert into USER(name,age,pwd) " +  
                "values('"+user.getName()+"','"+user.getAge()+"','"+user.getPwd()+"')");  
        if(i > 0){  
            flag = true;  
        }  
        DBconn.closeConn();  
        return flag;  
    }  
    public boolean login(String name, String pwd) {  
        boolean flag = false;  
        try {  
                DBconn.init();  
                ResultSet rs = DBconn.selectSql("select * from USER where name='"+name+"' and pwd='"+pwd+"'");  
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
    public List<USER> getUserAll() {  
        List<USER> list = new ArrayList<USER>();  
        try {  
            DBconn.init();  
            ResultSet rs = DBconn.selectSql("select * from USER");  
            while(rs.next()){  
                USER user = new USER();  
                user.setId(rs.getInt("id"));  
                user.setName(rs.getString("name"));  
                user.setPwd(rs.getString("pwd"));  
                user.setAge(rs.getInt("age"));  
                list.add(user);  
            }  
            DBconn.closeConn();  
            return list;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    public boolean update(int id,String name,int age, String pwd) {  
        boolean flag = false;  
        DBconn.init();  
        String sql ="update USER set name ='"+name  
                +"' , pwd ='"+pwd  
                +"' , age ='"+age+"' where id = "+id;  
        int i =DBconn.addUpdDel(sql);  
        if(i > 0){  
            flag = true;  
        }  
        DBconn.closeConn();  
        return flag;  
    }  
    public boolean delete(int id) {  
        boolean flag = false;  
        DBconn.init();  
        String sql = "delete  from USER where id="+id;  
        int i =DBconn.addUpdDel(sql);  
        if(i > 0){  
            flag = true;  
        }  
        DBconn.closeConn();  
        return flag;  
    }  
      
}  