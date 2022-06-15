package config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class CConnection {


    public static DataSource getDataSource(){
        SQLServerDataSource sqlserverdatasource = new SQLServerDataSource();
        sqlserverdatasource.setUser(EnumCConection.CONNECTIONDATA.getJDBC_USER());
        sqlserverdatasource.setPassword(EnumCConection.CONNECTIONDATA.getJDBC_PASSWORD());
        sqlserverdatasource.setURL(EnumCConection.CONNECTIONDATA.getJDBC_URL());   
        return sqlserverdatasource;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
 
    public static DataSource getDataSourceCFDI(){
    	SQLServerDataSource sqlserverdatasource = new SQLServerDataSource();
        sqlserverdatasource.setUser(EnumCConection.CONNECTIONDATACFDI.getJDBC_USER());
        sqlserverdatasource.setPassword(EnumCConection.CONNECTIONDATACFDI.getJDBC_PASSWORD());
        sqlserverdatasource.setURL(EnumCConection.CONNECTIONDATACFDI.getJDBC_URL());   
        return sqlserverdatasource;
    }
    
    public static Connection getConnectionCFDI() throws SQLException {
        return getDataSourceCFDI().getConnection();
    }
        
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
}
