package br.ufu.facom.persim.control;

import br.ufu.facom.persim.dao.ConnectionSQLiteDAO;
import br.ufu.facom.persim.dao.DatabaseConfigureDAO;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class DatabaseConfigControl {
    
    public static void resetDB(){
        ConnectionSQLiteDAO conn;
        try {
            conn = new ConnectionSQLiteDAO();
            DatabaseConfigureDAO.resetDB(conn);
            DisciplinaControl.getDisciplinas().clear();
            EventoControl.getEventos().clear();
            conn.closeDB();
        } catch (SQLException e) {
            System.err.println("Problema no script de delecao do banco: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
}
