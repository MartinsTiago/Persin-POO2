package dao;

import model.Evento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    
    private final GenericDAO dao;
    
    public EventoDAO(){
        dao = new GenericDAO();
    }
    
    public void save (Evento evento, ConnectionSQLiteDAO conn) throws SQLException, Exception{
        
        ArrayList<String> cols = new ArrayList<>();
        cols.add("event_datahora");
        cols.add("event_duracao");
        cols.add("event_descricao");
        
        ArrayList<String> values = new ArrayList<>();
        values.add(String.valueOf(evento.getDataHora()));
        values.add(String.valueOf(evento.getDuracao()));
        values.add(evento.getDescricao());
        
        dao.insert("evento", cols, values, conn);
    }
    
    public List<Evento> load (ConnectionSQLiteDAO conn) throws SQLException {

        ResultSet rs = dao.selectAll("evento", conn);
        
        return build(rs);
    }
    
    private List<Evento> build (ResultSet rs) throws SQLException{
        List<Evento> eventos = new ArrayList<>();
        while(rs.next()){
            eventos.add(new Evento(rs.getTimestamp("event_datahora"),
                    rs.getTimestamp("event_duracao"),
                    rs.getString("event_descricao")
            ) {});
        }
        return eventos;
        
    }
}
