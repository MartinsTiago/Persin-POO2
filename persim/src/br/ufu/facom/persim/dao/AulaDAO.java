package br.ufu.facom.persim.dao;

import br.ufu.facom.persim.model.Aula;
import br.ufu.facom.persim.model.Disciplina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AulaDAO {
   
    public void save (Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException {
        if (disc.getAulas() != null){
            for (Iterator it = disc.getAulas().iterator(); it.hasNext();) {
                Aula aula = (Aula) it.next();
                String query = "INSERT INTO aula (fk_disc_id, aula_horario, aula_diasemana) VALUES (?,?,?);";
                PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
                ps.setString(1, disc.getID());
                ps.setString(2, aula.getHorario());
                ps.setString(3, aula.getDiaSemana());
                ps.execute();
            }
        }
    }
    
    public List<Aula> load (String idDisc, ConnectionSQLiteDAO conn) throws SQLException {
        
        String query = "SELECT * FROM aula WHERE fk_disc_id = ?";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, idDisc);
        ResultSet rs = ps.executeQuery();
        return build(rs);
    }
    
    private List<Aula> build (ResultSet rs) throws SQLException {
        List<Aula> aulas = new ArrayList<>();
        while(rs.next()) {
            aulas.add(new Aula(rs.getString("aula_horario"),rs.getString("aula_diasemana")));
        }
        if (aulas.isEmpty()) {
            return null;
        }
        else {
            return aulas;
        }
    }
}
