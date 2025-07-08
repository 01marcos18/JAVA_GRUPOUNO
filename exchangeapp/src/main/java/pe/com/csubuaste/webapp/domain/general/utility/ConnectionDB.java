package pe.com.csubuaste.webapp.domain.general.utility;

import org.apache.commons.dbcp2.BasicDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    private static String url;
    private static String usename;
    private static String pasword;
    private static String dbname;
    private static String serverTimeZone;
    private static BasicDataSource pool;
    private static void setProperties(){
        Properties prop = new Properties();
        try (var input = ConnectionDB.class.getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(input);
            dbname = prop.getProperty("db.name");
            usename = prop.getProperty("db.user");
            pasword = prop.getProperty("db.pass");
            serverTimeZone = prop.getProperty("db.serverTimeZone");
            url = "jdbc:mysql://localhost:3306/exchange?serverTimezone=America/Lima";
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static BasicDataSource getInstance() throws SQLException {
        setProperties();
        if (pool==null){
            pool = new BasicDataSource();
            pool.setDriverClassName("com.mysql.cj.jdbc.Driver");
            pool.setUrl("jdbc:mysql://localhost:3306/exchange?serverTimezone=America/Lima");
            pool.setUsername("root");
            pool.setPassword("");
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);

        }
        return pool;
    }
    public static java.sql.Connection getConnection() throws SQLException {
        return  getInstance().getConnection();
    }
}
