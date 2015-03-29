package db;

import java.sql.Connection;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public abstract class DBConnectionFactory {
        String url = "jdbc:mysql://127.0.0.1:3306/schemaholder";
        String username = "HammerheadAdmin";
        String password = "DEVWEB";
    public static DBConnectionFactory getInstance(){
        return new DBConnectionFactoryImpl();
    }
    
    public abstract Connection getConnection();
}