package pweb.data;

import java.sql.*;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static SQLiteConnectionPoolDataSource dataSource = null;    

    private ConnectionPool() {                        
        dataSource = new SQLiteConnectionPoolDataSource();
        dataSource.setUrl("jdbc:sqlite:C:/sqlite3/EmailDB.db");                       
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {            
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}