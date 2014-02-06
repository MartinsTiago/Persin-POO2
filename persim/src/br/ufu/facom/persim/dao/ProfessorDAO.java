package br.ufu.facom.persim.dao;

import br.ufu.facom.persim.model.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO {
    
    public void save (Professor prof, ConnectionSQLiteDAO conn) throws SQLException{
        String query = "INSERT INTO professor VALUES (?, ?, ?)";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, prof.getNome());
        ps.setString(2, prof.getEmail());
        ps.setString(3, prof.getSala());
        ps.execute();
    }
    
    public Professor load (String nome, ConnectionSQLiteDAO conn) throws SQLException {
        String query = "SELECT FROM professor WHERE nome LIKE ?";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return build(rs);
    }
    
    public Professor build (ResultSet rs) throws SQLException {
        Professor prof = new Professor();
        prof.setNome(rs.getString("prof_nome"));
        prof.setEmail(rs.getString("prof_email"));
        prof.setSala(rs.getString("prof_sala"));
        return prof;
    }
}
