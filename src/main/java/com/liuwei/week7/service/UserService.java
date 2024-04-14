package com.liuwei.week7.service;

import com.liuwei.week7.Dao.UserDao;
import com.liuwei.week7.pojo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> QueryAllUser(Connection con) throws SQLException {
        String sql = "select * from usertable";
        List<User> users = new ArrayList<>();
        ResultSet result = UserDao.Query(sql,null,con);
        while (result.next())
        {
            String name = result.getString("name");
            String password = result.getString("password");
            Integer ID = result.getInt("ID");
            String birthday = result.getString("birthday");
            String email = result.getString("email");
            User user = new User(name, password, ID, birthday, email);
            users.add(user);
        }
        return users;
    }
}
