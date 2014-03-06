package dao;

import model.Disciplina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ExemploObject;


public class BibliografiaDAO {
    
    public void save (Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException, Exception {
        if (disc.getBibliografia() != null){
            for (String bibliografia : disc.getBibliografia()) {
                GenericDAO dao = new GenericDAO();                
                ArrayList<String> cols = new ArrayList<>();
                cols.add("fk_disc_id");
                cols.add("bib_texto");
                
                ArrayList<String> values = new ArrayList<>();
                values.add(disc.getID());
                values.add(bibliografia);
                
                dao.insert("bibliografia", cols, values, conn);
            }
        }
    }
    
    public List<String> load (String idDisc, ConnectionSQLiteDAO conn) throws SQLException {
        
        GenericDAO dao = new GenericDAO();
        
        ArrayList<String> cols = new ArrayList<>();
        cols.add("bib_texto");
        ExemploObject exemplo = new ExemploObject("fk_disc_id", "=", idDisc);
        ArrayList<ExemploObject> exemplos = new ArrayList<>();
        exemplos.add(exemplo);
        
        ResultSet rs = dao.selectByExample("bibliografia", cols, exemplos, conn);
        
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
