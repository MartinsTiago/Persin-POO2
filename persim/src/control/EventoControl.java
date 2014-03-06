package control;

import dao.ConnectionSQLiteDAO;
import dao.EventoAvaliativoDAO;
import dao.EventoDAO;
import model.Disciplina;
import model.EventoAluno;
import model.EventoAvaliativoAluno;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Singleton
public class EventoControl {
    
    private static EventoControl instance;
    private final List<EventoAluno> eventosDoMes;
    
    private EventoControl(List<EventoAluno> eventos) {
        this.eventosDoMes = eventos;
    }
    
    public static EventoControl getInstance() {
        if (instance == null) {
            instance = new EventoControl(load());
        }
        return instance;
    }
    
    public static List<EventoAluno> getEventos(){
        return getInstance().eventosDoMes;
    }
    
    public static void save (EventoAluno evento){
        try {
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            EventoDAO dao = new EventoDAO();
            dao.save(evento, conn);
            conn.closeDB();
            EventoControl.getEventos().add(evento);
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao salvar o evento: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    public static void save (EventoAvaliativoAluno evento, Disciplina disc){
        try {
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            EventoAvaliativoDAO dao = new EventoAvaliativoDAO();
            dao.save(evento, disc, conn);
            conn.closeDB();
            EventoControl.getEventos().add(evento);
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao salvar o evento: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    private static List<EventoAluno> load () {
        try {
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            EventoDAO dao = new EventoDAO();
            EventoAvaliativoDAO dao2 = new EventoAvaliativoDAO();
            List<EventoAluno> lista = dao.load(conn);
            List<EventoAvaliativoAluno> lista2 = dao2.load(conn);
            lista.addAll(lista2);
            conn.closeDB();
            return lista;
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao salvar o evento: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        
        return new ArrayList<>();
    }
}
