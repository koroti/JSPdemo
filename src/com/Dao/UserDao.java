package com.Dao;

import java.util.List;  

import com.Entity.USER; 

public interface UserDao {
	public boolean login(String name,String pwd);//登录  
    public boolean register(USER user);//注册  
    public List<USER> getUserAll();//返回用户信息集合  
    public boolean delete(int id) ;//根据id删除用户  
    public boolean update(int id,String name,int age, String pwd) ;//更新用户信息 
}
