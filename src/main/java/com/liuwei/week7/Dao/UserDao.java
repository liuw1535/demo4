package com.liuwei.week7.Dao;
import java.sql.*;

public class UserDao {
    public static ResultSet Query(String sql,Object[] o,Connection con) throws SQLException {
        if (sql != null && !sql.isEmpty() && con != null)
        {
            PreparedStatement statement = con.prepareStatement(sql);
            if (o != null)
            {
                for (int i = 0; i < o.length; i++)
                {
                    statement.setObject(i+1,o[i]);
                }
            }
            return statement.executeQuery();
        }
        else
        {
            return null;
        }
    }
}
