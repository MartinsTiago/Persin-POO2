package dao;

import java.io.FileNotFoundException;
import model.Aula;
import model.Disciplina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ExemploObject;

public class AulaDAO {
   
    public void save (Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException, ClassNotFoundException, FileNotFoundException, Exception {
        if (disc.getAulas() != null){
            for (Aula aula : disc.getAulas()) {
                GenericDAO dao = new GenericDAO();
                
                ArrayList<String> cols = new ArrayList<>();
                cols.add("fk_disc_id");
                cols.add("aula_horario");
                cols.add("aula_diasemana");
                
                ArrayList<String> values = new ArrayList<>();
                values.add(disc.getID());
                values.add(aula.getHorario());
                values.add(aula.getDiaSemana());
                
                //chama metodo que faz a inserção do framework
                dao.insert("aula", cols, values, conn);
            }
        }
    }
    
    public List<Aula> load (String idDisc, ConnectionSQLiteDAO conn) throws SQLException {
        
        GenericDAO dao = new GenericDAO();
        ArrayList<ExemploObject> exemplo = new ArrayList<>();
        ExemploObject exemploObj = new ExemploObject("fk_disc_id","=",idDisc);
        exemplo.add(exemploObj);
        
        ResultSet rs = dao.selectByExample("aula", "*", exemplo, conn);        
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
