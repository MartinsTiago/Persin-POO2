package dao;

import model.Disciplina;
import model.EventoAvaliativoAluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoAvaliativoDAO {

    public void save(EventoAvaliativoAluno evento, Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException {
        String query = "INSERT INTO evento_avaliativo "
                + "(event_datahora, event_duracao, event_descricao, event_aval_tipo, "
                + "event_aval_pontuacao, fk_disc_id)"
                + "VALUES(?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setTimestamp(1, evento.getDataHora());
        ps.setTimestamp(2, evento.getDuracao());
        ps.setString(3, evento.getDescricao());
        ps.setString(4, evento.getTipo());
        ps.setFloat(5, evento.getPontuacao());
        ps.setString(6, disc.getID());
        ps.execute();
    }
    
    public List<EventoAvaliativoAluno> load (ConnectionSQLiteDAO conn) throws SQLException {
        String query = "SELECT * FROM evento_avaliativo;";
        
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        return build(rs);
    }
    
    public List<EventoAvaliativoAluno> load (Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException {
        String query = "SELECT * FROM evento_avaliativo WHERE fk_disc_id LIKE ?;";
        
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, disc.getID());
        ResultSet rs = ps.executeQuery();
        
        return build(rs);
    }
    
    private List<EventoAvaliativoAluno> build (ResultSet rs) throws SQLException{
        List<EventoAvaliativoAluno> eventos = new ArrayList<>();
        while(rs.next()){
            EventoAvaliativoAluno evento = new EventoAvaliativoAluno();
            evento.setDataHora(rs.getTimestamp("event_datahora"));
            evento.setDuracao(rs.getTimestamp("event_duracao"));
            evento.setDescricao(rs.getString("event_descricao"));
            evento.setTipo(rs.getString("event_aval_tipo"));
            evento.setPontuacao(rs.getFloat("event_aval_pontuacao"));
            eventos.add(evento);
        }
        return eventos;
    }
}
