package pweb.data;

import java.sql.*;

import pweb.business.User;

public class UserDB 
{
    public static int insert(User user) 
    {
        ConnectionPool pool = null;
        Connection connection = null;
        PreparedStatement ps = null;        
        
        try 
        {
            pool = ConnectionPool.getInstance();
            connection = pool.getConnection();            
            
            String query = "INSERT INTO " 
                         + "USER (FIRST_NAME, LAST_NAME, EMAIL) "
                         + "VALUES (?, ?, ?)";
        
            ps = connection.prepareStatement(query);                        
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            return ps.executeUpdate();            
        }         
        catch (SQLException e) {
            System.out.println(e);
            return 0;
        } 
        finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    

    public static boolean emailExists(String email) 
    {
        ConnectionPool pool = null;
        Connection connection = null;
        PreparedStatement ps = null;        
        ResultSet rs = null;           
        
        try 
        {
            pool = ConnectionPool.getInstance();
            connection = pool.getConnection();            
            
            String query = "SELECT EMAIL FROM USER "
                         + "WHERE EMAIL = ?";
            
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        }         
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }             
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}