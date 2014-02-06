package br.ufu.facom.persim.dao;

import br.ufu.facom.persim.model.Disciplina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BibliografiaDAO {
    
    public void save (Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException {
        if (disc.getBibliografia() != null){
            for (Iterator it = disc.getBibliografia().iterator(); it.hasNext();) {
                String bibliografia = (String) it.next();
                String query = "INSERT INTO bibliografia (fk_disc_id, bib_texto) VALUES (?,?);";
                PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
                ps.setString(1, disc.getID());
                ps.setString(2, bibliografia);
                ps.execute();
            }
        }
    }
    
    public List<String> load (String idDisc, ConnectionSQLiteDAO conn) throws SQLException {
        
        String query = "SELECT bib_texto FROM bibliografia WHERE fk_disc_id = ?";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, idDisc);
        ResultSet rs = ps.executeQuery();
        return build(rs);
    }
    
    private List<String> build (ResultSet rs) throws SQLException {
        List<String> bibliografia = new ArrayList<>();
        while(rs.next()) {
            bibliografia.add(rs.getString("bib_texto"));
        }
        if (bibliografia.isEmpty()) {
            return null;
        }
        else {
            return bibliografia;
        }
    }
}
