package dao;

import config.Path;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Modulo para estabelecer conexao do banco a aplicacao.
 * Se ainda nao ha um DB configurado, InitialConfDAO configura.
 * criando um novo arquivo "myclassmanager.db".
 * InitialConfDAO.configure utiliza um script sql que esta na
 * pasta database.
 */

public class ConnectionSQLiteDAO {
    
    private Connection conn;
    
    public ConnectionSQLiteDAO () throws ClassNotFoundException, SQLException, FileNotFoundException {
        
        //testa plugin sqlite
        Class.forName("org.sqlite.JDBC");      
        
        this.conn = DriverManager.getConnection("jdbc:sqlite:"+Path.getDatabasePath("myclassmanager.db"));
            
        if (!DatabaseConfigureDAO.isConfigured(conn)){
            File SQLscript = new File(Path.getDatabasePath("myclassmanager.sql"));
            DatabaseConfigureDAO.configure(this.conn, SQLscript);
        }
        
        System.out.println("StatusDB: Conexão aberta.");
    }
    
    public Connection getDBConnection() {
        return conn;
    }
    
    public void closeDB () throws SQLException {
        this.conn.close();
        System.out.println("StatusDB: Conexão fechada.");
    }
    
}
